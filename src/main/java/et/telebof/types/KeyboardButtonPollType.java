package et.telebof.types;

import et.telebof.enums.PollType;
import java.io.Serializable;

public class KeyboardButtonPollType implements Serializable {

    private String type;
    public KeyboardButtonPollType(PollType type) {
        this.type = type.name().toLowerCase();
    }

}
