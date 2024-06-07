package et.telebof.types;

import java.io.Serializable;

public class InputLocationMessageContent implements Serializable {
    private Float latitude, longitude, horizontal_accuracy;
    private Integer live_period, heading, proximity_alert_radius;

    public InputLocationMessageContent latitude(float latitude) {
        this.latitude = latitude;
        return this;
    }

    public InputLocationMessageContent longitude(float longitude) {
        this.longitude = longitude;
        return this;
    }

    public InputLocationMessageContent horizontalAccuracy(float horizontalAccuracy) {
        this.horizontal_accuracy = horizontalAccuracy;
        return this;
    }

    public InputLocationMessageContent livePeriod(int livePeriod) {
        this.live_period = livePeriod;
        return this;
    }

    public InputLocationMessageContent heading(int heading) {
        this.heading = heading;
        return this;
    }

    public InputLocationMessageContent proximityAlertRadius(int proximityAlertRadius) {
        this.proximity_alert_radius = proximityAlertRadius;
        return this;
    }
}
