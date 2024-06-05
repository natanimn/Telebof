package et.telebof.types;

import java.io.Serializable;

public class ProximityAlertTriggered extends JsonSerializable implements Serializable {
    private User traveler, watcher;
    private Integer distance;

    public User getTraveler() {
        return traveler;
    }

    public User getWatcher() {
        return watcher;
    }

    public Integer getDistance() {
        return distance;
    }
}
