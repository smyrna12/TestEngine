package smyrna.base;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.sql.Timestamp;

/**
 * Created by Erdem.Akdogan on 5/29/15
 */
public class Activity {
    private final String created;
    private final Body body;
    private final Header header;

    //private constructor to enforce object creation through builder
    protected Activity(Builder builder) {
        this.created = builder.created;
        this.body = builder.body;
        this.header = builder.header;
    }

    public Header getHeader() {
        return header;
    }

    public Body getBody() {
        return body;
    }

    public String getCreated() {
        return created;
    }

    public static class Builder {
        private String created;
        private Body body;
        private Header header;

        //builder methods for setting property
        public Builder created(String beginTime, String endTime) {
            DateTimeFormatter dateFormat = ISODateTimeFormat.dateTimeNoMillis().withOffsetParsed();
            DateTime randomDate = new DateTime(getRandomTimeBetweenTwoDates(beginTime, endTime));
            this.created = dateFormat.print(randomDate.getMillis());
            return this;
        }

        public Builder body(Body body) {
            this.body = body;
            return this;
        }

        public Builder header(Header header) {
            this.header = header;
            return this;
        }

        //return fully build object
        public Activity build() {
            return new Activity(this);
        }

        private long getRandomTimeBetweenTwoDates(String beginTime, String endTime) {
            long offset = Timestamp.valueOf(beginTime).getTime();
            long end = Timestamp.valueOf(endTime).getTime();

            long diff = end - offset + 1;
            return offset + (long) (Math.random() * diff);
        }
    }
}

