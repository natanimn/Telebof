package et.telebof.types;

import java.io.Serializable;

public class GameHighScore implements Serializable {
    private Integer position, score;
    private User user;

    public User getUser() {
        return user;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getPosition() {
        return position;
    }

}
