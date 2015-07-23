package smyrna.factory.helper;

import org.apache.commons.lang3.RandomStringUtils;
import smyrna.base.*;
import smyrna.base.stats.VisitStats;
import smyrna.tester.Consts;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Erdem.Akdogan on 6/9/15
 */
public class VisitHelper {
    private String appKey;
    private String beginDate;
    private String endDate;

    public VisitHelper(String appKey, String beginDate, String endDate) {
        this.appKey = appKey;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public Activity createVisit(ActivityType type) {
        String sessionId = RandomStringUtils.randomNumeric(Consts.SESSION_ID_LENGTH);
        String source = Source.getRandom().name();
        Header header = new Header.Builder().appKey(appKey).utmSource(source).sessionId(sessionId).build();
        Data data = new Data();
        Random rnd = new Random();
        data.setFirstTouch(rnd.nextBoolean());
        data.setNewVisitor(rnd.nextBoolean());
        if (type.equals(ActivityType.VP)) {
            ProductName prod = ProductName.getRandom();
            Category category = new Category.Builder().categoryId(prod.categoryId).categoryName(prod.categoryName).build();
            List<Category> categories = Arrays.asList(category);
            Product product = new Product.Builder().name(prod.name()).modelCode(prod.modelCode).modelName(prod.modelName).categories(categories).build();
            data.getProducts().add(product);
        } else if (type.equals(ActivityType.VC)) {
            ProductName prod = ProductName.getRandom();
            Category category = new Category.Builder().categoryId(prod.categoryId).categoryName(prod.categoryName).build();
            data.setCategory(category);
        }
        String visitorId = RandomStringUtils.randomNumeric(Consts.VISITOR_ID_LENGTH);
        Body body = new Body.Builder().activityCode(type.value).activity(type.num).visitorId(visitorId).data(data).build();

        return new Activity.Builder().created(beginDate, endDate).header(header).body(body).build();
    }

    public Activity createVisit(ActivityType type, String sessionId, String visitorId, boolean firstTouch, boolean newVisitor, String source,
                                String productName, Integer modelCode, String modelName, Integer categoryId, String categoryName) {
        Header header = new Header.Builder().appKey(appKey).utmSource(source).sessionId(sessionId).build();
        Data data = new Data();
        data.setFirstTouch(firstTouch);
        data.setNewVisitor(newVisitor);
        if (type.equals(ActivityType.VP)) {
            Category category = new Category.Builder().categoryId(categoryId).categoryName(categoryName).build();
            List<Category> categories = Arrays.asList(category);
            Product product = new Product.Builder().name(productName).modelCode(modelCode).modelName(modelName).categories(categories).build();
            data.getProducts().add(product);
        } else if (type.equals(ActivityType.VC)) {
            Category category = new Category.Builder().categoryId(categoryId).categoryName(categoryName).build();
            data.setCategory(category);
        }
        Body body = new Body.Builder().activityCode(type.value).activity(type.num).visitorId(visitorId).data(data).build();

        return new Activity.Builder().created(beginDate, endDate).header(header).body(body).build();
    }

    public VisitStats generateStats(List<Activity> activityList, VisitStats stats) {
        for (Activity activity : activityList) {
            if (activity.getBody().getData().isFirstTouch()) {
                stats.setTotVisCount(stats.getTotVisCount() + 1);
            }
            if (activity.getBody().getData().isNewVisitor()) {
                stats.setNewVisCount(stats.getNewVisCount() + 1);
            }
            stats.getVisitorMap().put(activity.getBody().getVisitorId(), activity.getBody().getVisitorId());
            if (stats.getSessionMap().containsKey(activity.getHeader().getSessionId())) {
                int count = stats.getSessionMap().get(activity.getHeader().getSessionId());
                stats.getSessionMap().put(activity.getHeader().getSessionId(), count + 1);
                stats.getSessionMap2().put(activity.getHeader().getSessionId(), count + 1);
            } else {
                stats.getSessionMap().put(activity.getHeader().getSessionId(), 1);
            }
            stats.getSourceMap().put(activity.getHeader().getUtmSource(), stats.getSourceMap().get(activity.getHeader().getUtmSource()) + 1);
        }
        return stats;
    }
}
