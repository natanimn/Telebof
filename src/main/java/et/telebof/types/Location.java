package et.telebof.types;

import java.io.Serializable;

public class Location implements Serializable {
    public Float longitude, latitude, horizontal_accuracy;
    public Integer live_period, heading, proximity_alert_radius;

}
