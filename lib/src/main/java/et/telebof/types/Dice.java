package et.telebof.types;

import java.io.Serializable;

public class Dice implements Serializable {
    private String emoji;
    private Integer value;

    public Integer getValue() {
        return value;
    }

    public String getEmoji() {
        return emoji;
    }
}
