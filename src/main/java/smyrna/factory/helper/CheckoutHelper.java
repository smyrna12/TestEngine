package smyrna.factory.helper;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import smyrna.base.*;
import smyrna.base.stats.CheckoutStats;
import smyrna.tester.Consts;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

/**
 * Created by Erdem.Akdogan on 6/10/15
 */
public class CheckoutHelper {
    private String appKey;
    private String beginDate;
    private String endDate;

    public CheckoutHelper(String appKey, String beginDate, String endDate) {
        this.appKey = appKey;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public Activity createCheckout(ActivityType type, String sessionId, Integer productQuantity, BigDecimal totalAmount, String visitorId,
                                   String productName, Integer modelCode, String modelName) {
        Header header = new Header.Builder().appKey(appKey).sessionId(sessionId).build();
        Data data = new Data();
        Random rnd = new Random();
        data.setFirstTouch(rnd.nextBoolean());
        data.setNewVisitor(rnd.nextBoolean());
        Product product = new Product.Builder().name(productName).modelCode(modelCode).modelName(modelName).quantity(productQuantity).build();
        data.setTotalAmount(totalAmount);
        data.getProducts().add(product);
        Body body = new Body.Builder().activityCode(type.value).activity(type.num).visitorId(visitorId).data(data).build();

        return new Activity.Builder().created(beginDate, endDate).header(header).body(body).build();
    }

    public Activity createCheckout(ActivityType type) {
        String sessionId = RandomStringUtils.randomNumeric(Consts.SESSION_ID_LENGTH);
        Header header = new Header.Builder().appKey(appKey).sessionId(sessionId).build();

        Data data = new Data();
        Random rnd = new Random();
        data.setFirstTouch(rnd.nextBoolean());
        data.setNewVisitor(rnd.nextBoolean());
        int productQuantity = RandomUtils.nextInt(Consts.PRODUCT_QUANTITY_START_INCLUSIVE, Consts.PRODUCT_QUANTITY_END_EXCLUSIVE);
        int unitPrice = RandomUtils.nextInt(Consts.UNIT_PRICE_START_INCLUSIVE, Consts.UNIT_PRICE_END_EXCLUSIVE);
        ProductName prod = ProductName.getRandom();
        BigDecimal totalPrice = new BigDecimal(productQuantity * unitPrice);
        Product product = new Product.Builder().name(prod.name()).modelCode(prod.modelCode).modelName(prod.modelName).quantity(productQuantity).totalPrice(totalPrice).unitPrice(new BigDecimal(unitPrice)).build();
        data.setTotalAmount(totalPrice);
        data.getProducts().add(product);

        String visitorId = RandomStringUtils.randomNumeric(Consts.VISITOR_ID_LENGTH);
        Body body = new Body.Builder().activityCode(type.value).activity(type.num).visitorId(visitorId).data(data).build();

        return new Activity.Builder().created(beginDate, endDate).header(header).body(body).build();
    }

    public CheckoutStats generateStats(List<Activity> activityList, CheckoutStats stats) {
        for (Activity activity : activityList) {
            if (StringUtils.equals(activity.getBody().getActivityCode(), ActivityType.CC.value)) {
                if (!activity.getBody().getData().isNewVisitor()) {
                    stats.setOldVisCCCount(stats.getOldVisCCCount() + 1);
                }
                stats.getVisitorMap2().put(activity.getBody().getVisitorId(), activity.getBody().getVisitorId());

                stats.setTotEndorsement(stats.getTotEndorsement().add(activity.getBody().getData().getTotalAmount()));
                for (Product product : activity.getBody().getData().getProducts()) {
                    stats.setProdSaleCount(stats.getProdSaleCount() + product.getQuantity());
                }
                DateTimeFormatter formatter = DateTimeFormat.forPattern(Consts.DATE_PATTERN2);
                DateTime tmpCheckoutDate = formatter.parseDateTime(activity.getCreated());
                if (tmpCheckoutDate == null || tmpCheckoutDate.isBefore(stats.getFirstCheckoutCompletedDate())) {
                    stats.setFirstCheckoutCompletedDate(tmpCheckoutDate);
                    formatter = DateTimeFormat.forPattern(Consts.DATE_PATTERN);
                    DateTime dt = formatter.parseDateTime(beginDate);
                    stats.setDaysToFirstCheckoutCompletedDate(Days.daysBetween(dt, stats.getFirstCheckoutCompletedDate()).getDays());
                }
            }
        }

        return stats;
    }
}
