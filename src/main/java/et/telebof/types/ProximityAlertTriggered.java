package et.telebof.types;

import java.io.Serializable;

public class ProximityAlertTriggered extends JsonSerializable implements Serializable {
    public User traveler, watcher;
    public Integer distance;

}
