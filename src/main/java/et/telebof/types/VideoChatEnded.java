package et.telebof.types;

import java.io.Serializable;
import java.util.Objects;

public class VideoChatEnded implements Serializable {
    public Integer duration;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        VideoChatEnded that = (VideoChatEnded) object;
        return Objects.equals(duration, that.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(duration);
    }
}
