package et.telebof.types;

import java.io.Serializable;

public class InputLocationMessageContent implements Serializable {
    private double latitude, longitude, horizontal_accuracy;
    private Integer live_period, heading, proximity_alert_radius;

    public InputLocationMessageContent(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public InputLocationMessageContent horizontalAccuracy(double horizontalAccuracy) {
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
