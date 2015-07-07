package smyrna.factory;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import smyrna.base.*;
import smyrna.base.stats.Stats;
import smyrna.config.Profile;
import smyrna.tester.Consts;
import smyrna.tester.GenerateMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Erdem.Akdogan on 6/10/15
 */
public class NewsletterSubscribeFactory extends ActivityFactory {
    public Activity getActivity(String appKey, String beginDate, String endDate, String sessionId) {
        Header header = new Header.Builder().appKey(appKey).sessionId(sessionId).build();
        Data data = new Data();
        Random rnd = new Random();
        data.setFirstTouch(rnd.nextBoolean());
        data.setNewVisitor(rnd.nextBoolean());
        Body body = new Body.Builder().activityCode(ActivityType.NS.value).activity(ActivityType.NS.num).data(data).build();

        return new Activity.Builder().created(beginDate, endDate).header(header).body(body).build();
    }

    @Override
    protected Activity getActivity(String appKey, String beginDate, String endDate) {
        String sessionId = RandomStringUtils.randomAlphanumeric(Consts.SESSION_ID_LENGTH);
        Header header = new Header.Builder().appKey(appKey).sessionId(sessionId).build();
        Data data = new Data();
        Random rnd = new Random();
        data.setFirstTouch(rnd.nextBoolean());
        data.setNewVisitor(rnd.nextBoolean());
        Body body = new Body.Builder().activityCode(ActivityType.NS.value).activity(ActivityType.NS.num).data(data).build();

        return new Activity.Builder().created(beginDate, endDate).header(header).body(body).build();
    }

    @Override
    public List<Activity> getActivityList(Profile profile, int base) {
        List<Activity> activityList = new ArrayList<>();
        int nSubscribeCount;
        String beginDateStr = DateFormatUtils.format(profile.getDateInterval().getStartDate().toGregorianCalendar().getTime(), Consts.DATE_PATTERN);
        String endDateStr = DateFormatUtils.format(profile.getDateInterval().getEndDate().toGregorianCalendar().getTime(), Consts.DATE_PATTERN);
        if (StringUtils.equalsIgnoreCase(profile.getGenerationMethod(), GenerateMethod.AUTO.name())) {
            nSubscribeCount = RandomUtils.nextInt((int) (base * Consts.NEWSLETTER_SUBSCRIBE_COUNT_PERCENTAGE), base);
            for (int i = 0; i < nSubscribeCount; i++) {
                Activity activity = getActivity(profile.getName(), beginDateStr, endDateStr);
                activityList.add(activity);
            }
        } else {
            nSubscribeCount = profile.getNewsletterSubscribe().getCount();
            for (int i = 0; i < nSubscribeCount; i++) {
                Activity activity = getActivity(profile.getName(), beginDateStr, endDateStr, profile.getCheckoutCompleted().getValue().getSessionId());
                activityList.add(activity);
            }
        }

        return activityList;
    }

    @Override
    public Stats generateStats(List<Activity> activityList, Stats stats) {
        if (stats == null) stats = new Stats(activityList.size());
        return stats;
    }
}
