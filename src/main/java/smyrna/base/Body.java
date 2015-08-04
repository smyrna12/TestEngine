package smyrna.base;

/**
 * Created by Erdem.Akdogan on 6/3/15
 */
public class Body {
    private final String trackingId;
    private final String activity;
    private final String activityCode;
    private final String entityType;
    private final String entityId;
    private final String entityName;
    private final String isFirstActivity;
    private final String visitorId;
    private final Data data;

    //private constructor to enforce object creation through builder
    private Body(Builder builder) {
        this.trackingId = builder.trackingId;
        this.activity = builder.activity;
        this.activityCode = builder.activityCode;
        this.entityType = builder.entityType;
        this.entityId = builder.entityId;
        this.entityName = builder.entityName;
        this.isFirstActivity = builder.isFirstActivity;
        this.visitorId = builder.visitorId;
        this.data = builder.data;
    }

    public String getVisitorId() {
        return visitorId;
    }

    public Data getData() {
        return data;
    }

    public String getActivityCode() {
        return activityCode;
    }

    @Override
    public String toString() {
        return "trackingId='" + trackingId + '\'' +
                "; activity='" + activity + '\'' +
                "; activityCode='" + activityCode + '\'' +
                "; entityType='" + entityType + '\'' +
                "; entityId='" + entityId + '\'' +
                "; entityName='" + entityName + '\'' +
                "; isFirstActivity='" + isFirstActivity + '\'' +
                "; visitorId='" + visitorId + '\'' +
                ";" + data.toString();
    }

    public static class Builder {
        private String trackingId;
        private String activity;
        private String activityCode;
        private String entityType;
        private String entityId;
        private String entityName;
        private String isFirstActivity;
        private String visitorId;
        private Data data;

        //builder methods for setting property
        public Builder trackingId(String trackingId) {
            this.trackingId = trackingId;
            return this;
        }

        public Builder activity(String activity) {
            this.activity = activity;
            return this;
        }

        public Builder activityCode(String activityCode) {
            this.activityCode = activityCode;
            return this;
        }

        public Builder entityType(String entityType) {
            this.entityType = entityType;
            return this;
        }

        public Builder entityId(String entityId) {
            this.entityId = entityId;
            return this;
        }

        public Builder entityName(String entityName) {
            this.entityName = entityName;
            return this;
        }

        public Builder isFirstActivity(String isFirstActivity) {
            this.isFirstActivity = isFirstActivity;
            return this;
        }

        public Builder visitorId(String visitorId) {
            this.visitorId = visitorId;
            return this;
        }

        public Builder data(Data data) {
            this.data = data;
            return this;
        }

        //return fully build object
        public Body build() {
            return new Body(this);
        }

    }
}
