package smyrna.factory;

import smyrna.base.Activity;
import smyrna.base.stats.Stats;
import smyrna.config.Profile;

import java.util.List;

/**
 * Created by Erdem.Akdogan on 6/4/15
 */
public abstract class ActivityFactory {
    abstract Activity getActivity(String appKey, String beginDate, String endDate);

    public abstract List<Activity> getActivityList(Profile profile, int base);

    public abstract Stats generateStats(List<Activity> activityList, Stats stats);
}
