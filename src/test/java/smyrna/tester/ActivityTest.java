package smyrna.tester;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import smyrna.base.Activity;
import smyrna.base.ActivityType;
import smyrna.base.stats.CheckoutStats;
import smyrna.config.Profile;
import smyrna.config.SmyrnaConfig;
import smyrna.factory.ActivityFactory;
import smyrna.factory.ActivityFactoryProducer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Erdem.Akdogan on 6/3/15
 */
public class ActivityTest {

    private SmyrnaConfig config;
    private final Gson gson = new Gson();
    private static final Logger logger2 = Logger.getLogger("smyrna.tester");

    @Before
    public void setup() throws IOException, SchemaValidator.SchemaException, JAXBException {

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
        config = (SmyrnaConfig) unmarshaller.unmarshal(new ByteArrayInputStream(xmlArr));
    }


    @Test
    public void testBasic() throws Exception {
        TestBuilder builder = new TestBuilder(true);
        builder.build();

    }

    @Test
    public void shouldProduceIdentitySignup() {
        for (Profile profile : config.getProfile()) {
            int iSignupCount = 0;
            ActivityFactory factory = ActivityFactoryProducer.getFactory(ActivityType.IS);
            List<Activity> activityList;
            if (factory != null) {
                activityList = factory.getActivityList(profile, 10);
                assertTrue(activityList.size() > 0);
                System.out.println(gson.toJson(activityList.get(0), Activity.class));
            }
        }
    }

    @Test
    public void shouldProduceCheckoutCompletedAndGenerateStats() {
        for (Profile profile : config.getProfile()) {
            CheckoutStats cStats = null;
            int iSignupCount = 0;
            ActivityFactory factory = ActivityFactoryProducer.getFactory(ActivityType.CC);
            List<Activity> activityList;
            if (factory != null) {
                activityList = factory.getActivityList(profile, 10);
                assertTrue(activityList.size() > 0);
                System.out.println(gson.toJson(activityList.get(0), Activity.class));

                if (activityList.size() > 0) {
                    cStats = (CheckoutStats) factory.generateStats(activityList, cStats);
                    System.out.println(gson.toJson(cStats));
                }
            }
        }
    }
}
