package et.telebof.types;

import java.io.Serializable;

public class VideoChatScheduled extends JsonSerializable implements Serializable {
    private Integer start_date;

    public Integer getStartDate() {
        return start_date;
    }
}
