package et.telebof.types;

import java.io.Serializable;
import java.util.Objects;

public class ProximityAlertTriggered implements Serializable {
    public User traveler, watcher;
    public Integer distance;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ProximityAlertTriggered that = (ProximityAlertTriggered) object;
        return Objects.equals(traveler, that.traveler) && Objects.equals(watcher, that.watcher) &&
                Objects.equals(distance, that.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(traveler, watcher, distance);
    }


    @Override
    public String toString() {
        return "ProximityAlertTriggered{" +
                "traveler=" + traveler +
                ", watcher=" + watcher +
                ", distance=" + distance +
                '}';
    }
}
