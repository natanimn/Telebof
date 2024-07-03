package et.telebof.types;

import java.io.Serializable;

public class ChatBoostSource implements Serializable {
    public String source, giveaway_message_id;
    public User user;
    public Boolean is_unclaimed;
}
