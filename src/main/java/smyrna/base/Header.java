package smyrna.base;

/**
 * Created by Erdem.Akdogan on 6/3/15
 */
public class Header {
    private final String appKey;
    private final String token;
    private final String appId;
    private final String sessionId;
    private final String agent;
    private final String channel;
    private final String referrer;
    private final String referringDomain;
    private final String uri;
    private final String queryString;
    private final String userId;
    private final String client;
    private final String ipAddress;
    private final String marketingActivityID;
    private final String utmSource;
    private final String utmMedium;
    private final String utmTerm;
    private final String utmContent;
    private final String utmCampaign;
    //private ThirdPartyParameters thirdPartyParameters;


    //private constructor to enforce object creation through builder
    private Header(Builder builder) {
        this.appKey = builder.appKey;
        this.token = builder.token;
        this.appId = builder.appId;
        this.sessionId = builder.sessionId;
        this.agent = builder.agent;
        this.channel = builder.channel;
        this.referrer = builder.referrer;
        this.referringDomain = builder.referringDomain;
        this.uri = builder.uri;
        this.queryString = builder.queryString;
        this.userId = builder.userId;
        this.client = builder.client;
        this.ipAddress = builder.ipAddress;
        this.marketingActivityID = builder.marketingActivityID;
        this.utmSource = builder.utmSource;
        this.utmMedium = builder.utmMedium;
        this.utmTerm = builder.utmTerm;
        this.utmContent = builder.utmContent;
        this.utmCampaign = builder.utmCampaign;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getUtmSource() {
        return utmSource;
    }

    public static class Builder {
        private String appKey;
        private String token;
        private String appId;
        private String sessionId;
        private String agent;
        private String channel;
        private String referrer;
        private String referringDomain;
        private String uri;
        private String queryString;
        private String userId;
        private String client;
        private String ipAddress;
        private String marketingActivityID;
        private String utmSource;
        private String utmMedium;
        private String utmTerm;
        private String utmContent;
        private String utmCampaign;

        //builder methods for setting property
        public Builder appKey(String appKey) {
            this.appKey = appKey;
            return this;
        }

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder appId(String appId) {
            this.appId = appId;
            return this;
        }

        public Builder sessionId(String sessionId) {
            this.sessionId = sessionId;
            return this;
        }

        public Builder agent(String agent) {
            this.agent = agent;
            return this;
        }

        public Builder channel(String channel) {
            this.channel = channel;
            return this;
        }

        public Builder referrer(String referrer) {
            this.referrer = referrer;
            return this;
        }

        public Builder referringDomain(String referringDomain) {
            this.referringDomain = referringDomain;
            return this;
        }

        public Builder uri(String uri) {
            this.uri = uri;
            return this;
        }

        public Builder queryString(String queryString) {
            this.queryString = queryString;
            return this;
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder client(String client) {
            this.client = client;
            return this;
        }

        public Builder ipAddress(String ipAddress) {
            this.ipAddress = ipAddress;
            return this;
        }

        public Builder marketingActivityID(String marketingActivityID) {
            this.marketingActivityID = marketingActivityID;
            return this;
        }

        public Builder utmSource(String utmSource) {
            this.utmSource = utmSource;
            return this;
        }

        public Builder utmMedium(String utmMedium) {
            this.utmMedium = utmMedium;
            return this;
        }

        public Builder utmTerm(String utmTerm) {
            this.utmTerm = utmTerm;
            return this;
        }

        public Builder utmContent(String utmContent) {
            this.utmContent = utmContent;
            return this;
        }

        public Builder utmCampaign(String utmCampaign) {
            this.utmCampaign = utmCampaign;
            return this;
        }

        //return fully build object
        public Header build() {
            return new Header(this);
        }

    }
}
