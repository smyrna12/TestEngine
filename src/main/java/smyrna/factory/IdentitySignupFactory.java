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
 * Created by Erdem.Akdogan on 6/4/15
 */
public class IdentitySignupFactory extends ActivityFactory {
    public Activity getActivity(String appKey, String beginDate, String endDate, String sessionId, String visitorId) {
        Header header = new Header.Builder().appKey(appKey).sessionId(sessionId).build();
        Data data = new Data();
        Random rnd = new Random();
        data.setFirstTouch(rnd.nextBoolean());
        data.setNewVisitor(rnd.nextBoolean());
        Body body = new Body.Builder().activityCode(ActivityType.IS.value).activity(ActivityType.IS.num).visitorId(visitorId).data(data).build();

        return new Activity.Builder().created(beginDate, endDate).header(header).body(body).build();
    }

    @Override
    protected Activity getActivity(String appKey, String beginDate, String endDate) {
        String sessionId = RandomStringUtils.randomAlphanumeric(Consts.SESSION_ID_LENGTH);
        Header header = new Header.Builder().appKey(appKey).sessionId(sessionId).build();
        User user = User.getRandom();
        Data data = new Data();
        Random rnd = new Random();
        data.setFirstTouch(rnd.nextBoolean());
        data.setNewVisitor(rnd.nextBoolean());
        data.setUserName(user.name());
        data.setFullName(user.fullName);
        data.setGender(user.gender);
        data.setAge(user.age);
        data.setBirthDate(user.birthDate);
        String visitorId = RandomStringUtils.randomNumeric(Consts.VISITOR_ID_LENGTH);
        Body body = new Body.Builder().activityCode(ActivityType.IS.value).activity(ActivityType.IS.num).visitorId(visitorId).data(data).build();

        return new Activity.Builder().created(beginDate, endDate).header(header).body(body).build();
    }

    @Override
    public List<Activity> getActivityList(Profile profile, int base) {
        List<Activity> activityList = new ArrayList<>();
        int signupCount;
        String beginDateStr = DateFormatUtils.format(profile.getDateInterval().getStartDate().toGregorianCalendar().getTime(), Consts.DATE_PATTERN);
        String endDateStr = DateFormatUtils.format(profile.getDateInterval().getEndDate().toGregorianCalendar().getTime(), Consts.DATE_PATTERN);
        if (StringUtils.equalsIgnoreCase(profile.getGenerationMethod(), GenerateMethod.AUTO.name())) {
            signupCount = RandomUtils.nextInt((int) (base * Consts.SIGNUP_COUNT_PERCENTAGE), base);
            for (int i = 0; i < signupCount; i++) {
                Activity activity = getActivity(profile.getName(), beginDateStr, endDateStr);
                activityList.add(activity);
            }
        } else {
            signupCount = profile.getIdentitySignup().getCount();
            for (int i = 0; i < signupCount; i++) {
                Activity activity = getActivity(profile.getName(), beginDateStr, endDateStr, profile.getIdentitySignup().getSessionId(), profile.getIdentitySignup().getVisitorId());
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
