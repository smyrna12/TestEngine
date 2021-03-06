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
public class VisitCategoryFactory extends ActivityFactory {
    private VisitHelper vHelper;

    Activity getActivity(String appKey, String beginDate, String endDate, String sessionId, String visitorId, boolean firstTouch, boolean newVisitor, String source,
                         Integer categoryId, String categoryName) {
        vHelper = new VisitHelper(appKey, beginDate, endDate);
        return vHelper.createVisit(ActivityType.VC, sessionId, visitorId, firstTouch, newVisitor, source, null, null, null, categoryId, categoryName);
    }

    @Override
    protected Activity getActivity(String appKey, String beginDate, String endDate) {
        vHelper = new VisitHelper(appKey, beginDate, endDate);
        return vHelper.createVisit(ActivityType.VC);
    }

    @Override
    public List<Activity> getActivityList(Profile profile, int base) {
        List<Activity> activityList = new ArrayList<>();
        int visitCCount;
        String beginDateStr = DateFormatUtils.format(profile.getDateInterval().getStartDate().toGregorianCalendar().getTime(), Consts.DATE_PATTERN);
        String endDateStr = DateFormatUtils.format(profile.getDateInterval().getEndDate().toGregorianCalendar().getTime(), Consts.DATE_PATTERN);
        if (StringUtils.equalsIgnoreCase(profile.getGenerationMethod(), GenerateMethod.AUTO.name())) {
            visitCCount = RandomUtils.nextInt((int) (base * Consts.VISIT_CATEGORY_COUNT_PERCENTAGE), base);
            for (int i = 0; i < visitCCount; i++) {
                Activity activity = getActivity(profile.getName(), beginDateStr, endDateStr);
                activityList.add(activity);
            }
        } else {
            visitCCount = profile.getVisitCategory().getCount();
            for (int i = 0; i < visitCCount; i++) {
                Activity activity = getActivity(profile.getName(), beginDateStr, endDateStr, profile.getVisitCategory().getSessionId(), profile.getVisitCategory().getVisitorId(),
                        profile.getVisitCategory().isFirstTouch(), profile.getVisitCategory().isNewVisitor(), profile.getVisitCategory().getSource(),
                        profile.getVisitCategory().getCategoryId(), profile.getVisitCategory().getCategoryName());
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
