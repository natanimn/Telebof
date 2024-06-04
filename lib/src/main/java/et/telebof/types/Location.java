package et.telebof.types;

import java.io.Serializable;

public class Location implements Serializable {
    private Float longitude, latitude, horizontal_accuracy;
    private Integer live_period, heading, proximity_alert_radius;

    public Float getHorizontalAccuracy() {
        return horizontal_accuracy;
    }

    public Float getLatitude() {
        return latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public Integer getHeading() {
        return heading;
    }

    public Integer getLivePeriod() {
        return live_period;
    }

    public Integer getProximityAlertRadius() {
        return proximity_alert_radius;
    }

}
