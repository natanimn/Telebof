package et.telebof.types;

import java.io.Serializable;
import java.util.List;

public class PollAnswer implements Serializable {
    public String poll_id;
    public User user;
    public List<Integer> options_id;
    public Chat voter_chat;

}
