package et.telebof.types;

import java.io.Serializable;
import java.util.List;

public class PollAnswer implements Serializable {
    private String poll_id;
    private User user;
    private List<Integer> options_id;


    public String getPollId() {
        return poll_id;
    }

    public User getUser() {
        return user;
    }

    public List<Integer> getOptionsId() {
        return options_id;
    }
}
