package smyrna.factory;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import smyrna.base.Activity;
import smyrna.base.ActivityType;
import smyrna.base.stats.Stats;
import smyrna.base.stats.VisitStats;
import smyrna.config.Profile;
import smyrna.factory.helper.VisitHelper;
import smyrna.tester.Consts;
import smyrna.tester.GenerateMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Erdem.Akdogan on 6/9/15
 */
public class VisitProductFactory extends ActivityFactory {
    private VisitHelper vHelper;

    Activity getActivity(String appKey, String beginDate, String endDate, String sessionId, String visitorId, boolean firstTouch, boolean newVisitor, String source,
                         String productName, int modelCode, String modelName) {
        vHelper = new VisitHelper(appKey, beginDate, endDate);
        return vHelper.createVisit(ActivityType.VP, sessionId, visitorId, firstTouch, newVisitor, source, productName, modelCode, modelName, null, null);
    }

    @Override
    protected Activity getActivity(String appKey, String beginDate, String endDate) {
        vHelper = new VisitHelper(appKey, beginDate, endDate);
        return vHelper.createVisit(ActivityType.VP);
    }

    @Override
    public List<Activity> getActivityList(Profile profile, int base) {
        List<Activity> activityList = new ArrayList<>();
        int visitPCount;
        String beginDateStr = DateFormatUtils.format(profile.getDateInterval().getStartDate().toGregorianCalendar().getTime(), Consts.DATE_PATTERN);
        String endDateStr = DateFormatUtils.format(profile.getDateInterval().getEndDate().toGregorianCalendar().getTime(), Consts.DATE_PATTERN);
        if (StringUtils.equalsIgnoreCase(profile.getGenerationMethod(), GenerateMethod.AUTO.name())) {
            visitPCount = RandomUtils.nextInt((int) (base * Consts.VISIT_PRODUCT_COUNT_PERCENTAGE), base);
            for (int i = 0; i < visitPCount; i++) {
                Activity activity = getActivity(profile.getName(), beginDateStr, endDateStr);
                activityList.add(activity);
            }
        } else {
            visitPCount = profile.getVisitProduct().getCount();
            for (int i = 0; i < visitPCount; i++) {
                Activity activity = getActivity(profile.getName(), beginDateStr, endDateStr, profile.getVisitProduct().getSessionId(), profile.getVisitProduct().getVisitorId(),
                        profile.getVisitProduct().isFirstTouch(), profile.getVisitProduct().isNewVisitor(), profile.getVisitProduct().getSource(),
                        profile.getVisitProduct().getProductName(), profile.getVisitProduct().getModelCode(), profile.getVisitProduct().getModelName());
                activityList.add(activity);
            }
        }

        return activityList;
    }

    @Override
    public VisitStats generateStats(List<Activity> activityList, Stats stats) {
        if (vHelper == null) {
            throw new RuntimeException("First you must call getActivityList method.");
        }

        if (stats == null)
            stats = new VisitStats(activityList.size());
        else
            stats.setCount(stats.getCount() + activityList.size());
        return vHelper.generateStats(activityList, (VisitStats) stats);
    }
}
