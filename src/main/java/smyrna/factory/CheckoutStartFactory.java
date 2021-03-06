package smyrna.factory;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import smyrna.base.Activity;
import smyrna.base.ActivityType;
import smyrna.base.stats.CheckoutStats;
import smyrna.base.stats.Stats;
import smyrna.config.Profile;
import smyrna.factory.helper.CheckoutHelper;
import smyrna.tester.Consts;
import smyrna.tester.GenerateMethod;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Erdem.Akdogan on 6/10/15
 */
public class CheckoutStartFactory extends ActivityFactory {
    private CheckoutHelper cHelper;

    Activity getActivity(String appKey, String beginDate, String endDate, String sessionId, Integer productQuantity, BigDecimal totalAmount, String visitorId,
                         String productName, Integer modelCode, String modelName) {
        cHelper = new CheckoutHelper(appKey, beginDate, endDate);
        return cHelper.createCheckout(ActivityType.CS, sessionId, productQuantity, totalAmount, visitorId, productName, modelCode, modelName);
    }

    @Override
    protected Activity getActivity(String appKey, String beginDate, String endDate) {
        cHelper = new CheckoutHelper(appKey, beginDate, endDate);
        return cHelper.createCheckout(ActivityType.CS);
    }

    @Override
    public List<Activity> getActivityList(Profile profile, int base) {
        List<Activity> activityList = new ArrayList<>();
        int cStartCount;
        String beginDateStr = DateFormatUtils.format(profile.getDateInterval().getStartDate().toGregorianCalendar().getTime(), Consts.DATE_PATTERN);
        String endDateStr = DateFormatUtils.format(profile.getDateInterval().getEndDate().toGregorianCalendar().getTime(), Consts.DATE_PATTERN);
        if (StringUtils.equalsIgnoreCase(profile.getGenerationMethod(), GenerateMethod.AUTO.name())) {
            cStartCount = RandomUtils.nextInt((int) (base * Consts.CHECKOUT_START_COUNT_PERCENTAGE), base);
            for (int i = 0; i < cStartCount; i++) {
                Activity activity = getActivity(profile.getName(), beginDateStr, endDateStr);
                activityList.add(activity);
            }
        } else {
            cStartCount = profile.getCheckoutStart().getCount();
            for (int i = 0; i < cStartCount; i++) {
                Activity activity = getActivity(profile.getName(), beginDateStr, endDateStr, profile.getCheckoutStart().getSessionId(),
                        profile.getCheckoutStart().getProductQuantity(), profile.getCheckoutStart().getTotalAmount(),
                        profile.getCheckoutStart().getVisitorId(), profile.getCheckoutStart().getProductName(), profile.getCheckoutStart().getModelCode(),
                        profile.getCheckoutStart().getModelName());
                activityList.add(activity);
            }
        }

        return activityList;
    }

    @Override
    public Stats generateStats(List<Activity> activityList, Stats stats) {
        if (cHelper == null) {
            throw new RuntimeException("First you must call getActivityList method.");
        }

        if (stats == null) stats = new CheckoutStats(activityList.size());
        return cHelper.generateStats(activityList, (CheckoutStats) stats);
    }
}
