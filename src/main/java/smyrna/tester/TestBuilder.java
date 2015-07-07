package smyrna.tester;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Days;
import smyrna.base.Activity;
import smyrna.base.ActivityType;
import smyrna.base.stats.CheckoutStats;
import smyrna.base.stats.Stats;
import smyrna.base.stats.VisitStats;
import smyrna.config.Profile;
import smyrna.config.SmyrnaConfig;
import smyrna.factory.ActivityFactory;
import smyrna.factory.ActivityFactoryProducer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Erdem.Akdogan on 6/1/15
 */
class TestBuilder {
    private boolean test;
    private int days;
    private SmyrnaConfig config;
    private final Gson gson = new Gson();

    private static final Logger logger = Logger.getLogger("smyrna.base");
    private static final Logger logger2 = Logger.getLogger("smyrna.tester");
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("application-messages", new Locale("TR"));

    public TestBuilder(boolean test) throws Exception {
        this.test = test;

        InputStream xmlStream = null;
        try {
            xmlStream = new FileInputStream("smyrna-testsuite-configuration.xml");
        } catch (java.io.FileNotFoundException fnfe) {
            logger2.warn("Configuration file could not be found. Program is going to start with default settings.");
        }
        if (xmlStream == null) {
            xmlStream = getClass().getClassLoader().getResourceAsStream("smyrna-testsuite-configuration.xml");
        }
        byte[] xmlArr = IOUtils.toByteArray(xmlStream);

        Source xmlFile = new StreamSource(new ByteArrayInputStream(xmlArr));
        URL schemaResource = getClass().getClassLoader().getResource("smyrna-testsuite-configuration.xsd");

        SchemaValidator validator = new SchemaValidator();
        String error = validator.validate(schemaResource, xmlFile);
        if (StringUtils.isNotEmpty(error)) {
            throw new RuntimeException(error);
        }

        //read configuration file
        JAXBContext context = JAXBContext.newInstance(SmyrnaConfig.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        this.config = (SmyrnaConfig) unmarshaller.unmarshal(new ByteArrayInputStream(xmlArr));
    }

    public void build() {
        //generate activity batch data and pass to API
        for (Profile profile : config.getProfile()) {
            String environment = profile.getEnvironment();
            days = Days.daysBetween(new DateTime(profile.getDateInterval().getStartDate().toGregorianCalendar().getTime()),
                    new DateTime(profile.getDateInterval().getEndDate().toGregorianCalendar().getTime())).getDays();
            ActivityFactory factory = ActivityFactoryProducer.getFactory(ActivityType.VR);
            List<Activity> activityList;
            VisitStats vStats = null;
            int vBaseCount = 0;
            if (factory != null) {
                activityList = factory.getActivityList(profile, 0);
                activityList = processActivityList(activityList);
                vBaseCount = activityList.size();
                if (vBaseCount > 0)
                    vStats = (VisitStats) factory.generateStats(activityList, vStats);
            }

            int vCategoryCount = 0;
            factory = ActivityFactoryProducer.getFactory(ActivityType.VC);
            if (factory != null) {
                activityList = factory.getActivityList(profile, vBaseCount);
                activityList = processActivityList(activityList);
                vCategoryCount = activityList.size();
                if (vCategoryCount > 0)
                    vStats = (VisitStats) factory.generateStats(activityList, vStats);
            }

            int vProductCount = 0;
            factory = ActivityFactoryProducer.getFactory(ActivityType.VP);
            if (factory != null) {
                activityList = factory.getActivityList(profile, vBaseCount);
                activityList = processActivityList(activityList);
                vProductCount = activityList.size();
                if (vProductCount > 0)
                    vStats = (VisitStats) factory.generateStats(activityList, vStats);
            }

            int iSignupCount = 0;
            factory = ActivityFactoryProducer.getFactory(ActivityType.IS);
            if (factory != null) {
                activityList = factory.getActivityList(profile, vBaseCount);
                activityList = processActivityList(activityList);
                iSignupCount = activityList.size();
                if (iSignupCount > 0) {
                    Stats iSignupStats = factory.generateStats(activityList, null);
                }
            }

            CheckoutStats cStats = null;
            int cStartCount = 0;
            factory = ActivityFactoryProducer.getFactory(ActivityType.CS);
            if (factory != null) {
                activityList = factory.getActivityList(profile, iSignupCount);
                activityList = processActivityList(activityList);
                cStartCount = activityList.size();
                if (cStartCount > 0)
                    cStats = (CheckoutStats) factory.generateStats(activityList, cStats);
            }

            int cCompletedCount = 0;
            factory = ActivityFactoryProducer.getFactory(ActivityType.CC);
            if (factory != null) {
                activityList = factory.getActivityList(profile, cStartCount);
                activityList = processActivityList(activityList);
                cCompletedCount = activityList.size();
                if (cCompletedCount > 0)
                    cStats = (CheckoutStats) factory.generateStats(activityList, cStats);
            }

            int nSubscribeCount = 0;
            factory = ActivityFactoryProducer.getFactory(ActivityType.NS);
            if (factory != null) {
                activityList = factory.getActivityList(profile, iSignupCount);
                activityList = processActivityList(activityList);
                nSubscribeCount = activityList.size();
                if (nSubscribeCount > 0) {
                    Stats nSubscribeStats = factory.generateStats(activityList, null);
                }
            }

            log(vStats, vCategoryCount, vProductCount, iSignupCount, cStartCount, cCompletedCount, cStats, nSubscribeCount);
        }
    }

    private List<Activity> processActivityList(List<Activity> activityList) {
        List<Activity> nActivityList = new ArrayList<>();
        for (int i = 0; i < activityList.size(); i++) {
            int response = sendActivity(activityList.get(i));
            if (response == 0) {
                nActivityList.add(activityList.get(i));
                logger2.info(gson.toJson(activityList.get(i), Activity.class));
            }
        }
        return nActivityList;
    }

    private int sendActivity(Activity activity) {
        //load activity data to API
        String activityJson = gson.toJson(activity, Activity.class);
        try {
            String urlString;
            if (test) {
                urlString = "http://54.93.81.127:81/" + "/activity/push";
            } else {
                urlString = "http://172.31.29.193:81/" + "/activity/push";
            }
            logger2.info("ws url: " + urlString);
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setConnectTimeout(3000);
            conn.setReadTimeout(3000);

            OutputStream os = conn.getOutputStream();
            os.write(activityJson.getBytes());
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED && conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            conn.disconnect();
        } catch (Exception e) {
            logger2.error(e.getMessage(), e);
            return -1;
        }

        return 0;
    }

    private void log(VisitStats vStats, int vCategoryCount, int vProductCount, int iSignupCount, int cStartCount, int cCompletedCount, CheckoutStats cStats, int nSubscribeCount) {
        try {
            float noReturnPer = (float) (vStats.getSessionMap().size() - vStats.getSessionMap2().size()) / vStats.getSessionMap().size();
            BigDecimal bd = new BigDecimal(Float.toString(noReturnPer));
            bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
            float saleConvPer = (float) cCompletedCount / vStats.getNewVisCount();
            BigDecimal bd2 = new BigDecimal(Float.toString(saleConvPer));
            bd2 = bd2.setScale(2, BigDecimal.ROUND_HALF_UP);
            float avgcCompletedAmount = cStats.getTotEndorsement().floatValue() / (float) cCompletedCount;
            BigDecimal bd3 = new BigDecimal(Float.toString(avgcCompletedAmount));
            bd3 = bd3.setScale(2, BigDecimal.ROUND_HALF_UP);
            float repVisPer = (float) (vStats.getCount() - vStats.getNewVisCount()) / vStats.getVisitorMap().size();
            BigDecimal bd4 = new BigDecimal(Float.toString(repVisPer));
            bd4 = bd4.setScale(2, BigDecimal.ROUND_HALF_UP);
            double unCompCheckPer = (cStartCount - cCompletedCount) / cStartCount;
            BigDecimal bd5 = new BigDecimal(Double.toString(unCompCheckPer));
            bd5 = bd5.setScale(2, BigDecimal.ROUND_HALF_UP);
            double nSubscPer = nSubscribeCount / vStats.getTotVisCount();
            BigDecimal bd6 = new BigDecimal(Double.toString(nSubscPer));
            bd6 = bd6.setScale(2, BigDecimal.ROUND_HALF_UP);

            String visitInfoMsg = MessageFormat.format(BUNDLE.getString("smyrna.visit.resource.information"), vStats.getCount(),
                    vStats.getTotVisCount(), vStats.getVisitorMap().size(), vStats.getNewVisCount(),
                    bd.floatValue() * 100, bd2.floatValue() * 100, bd4.floatValue() * 100, vCategoryCount / vStats.getCount(), vProductCount / vStats.getCount());
            logger.info(visitInfoMsg);

            String visitSourceInfoMsg = MessageFormat.format(BUNDLE.getString("smyrna.visit.source.information"),
                    vStats.getSourceMap().get(smyrna.base.Source.Facebook.name()),
                    vStats.getSourceMap().get(smyrna.base.Source.Google.name()),
                    vStats.getSourceMap().get(smyrna.base.Source.Direct.name()));
            logger.info(visitSourceInfoMsg);

            String signupInfoMsg = MessageFormat.format(BUNDLE.getString("smyrna.identity.signup.information"), iSignupCount, iSignupCount, iSignupCount, iSignupCount / vStats.getTotVisCount());
            logger.info(signupInfoMsg);

            String cCompletedInfoMsg = MessageFormat.format(BUNDLE.getString("smyrna.checkout.completed.information"), cCompletedCount,
                    cStats.getTotEndorsement().toPlainString(), cCompletedCount,
                    cStats.getProdSaleCount(), bd3.floatValue(), (float) cCompletedCount / days, cStats.getDaysToFirstCheckoutCompletedDate(),
                    cStats.getProdSaleCount() / cCompletedCount,
                    cStats.getTotEndorsement().floatValue() / vStats.getCount(), cStats.getTotEndorsement().floatValue() / cStats.getVisitorMap2().size(),
                    (float) cCompletedCount / cStats.getVisitorMap2().size(), (float) cStats.getOldVisCCCount() / cCompletedCount, bd5.floatValue() * 100);
            logger.info(cCompletedInfoMsg);

            String newsSubscribeMsg = MessageFormat.format(BUNDLE.getString("smyrna.newsletter.subscribe.information"), nSubscribeCount, bd6.floatValue() * 100, nSubscribeCount);
            logger.info(newsSubscribeMsg);
        } catch (NullPointerException npe) {
            logger2.error("Log cannot be generated.", npe);
        }
    }


}
