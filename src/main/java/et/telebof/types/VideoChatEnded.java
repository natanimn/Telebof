package et.telebof.types;

import java.io.Serializable;

public class VideoChatEnded extends JsonSerializable implements Serializable {
    private Integer duration;

    public Integer getDuration() {
        return duration;
    }
}
