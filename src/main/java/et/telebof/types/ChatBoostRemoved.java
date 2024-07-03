package et.telebof.types;

import java.io.Serializable;

public class ChatBoostRemoved implements Serializable {
    public Chat chat;
    public String boost_id;
    public Integer removed_date;
    public ChatBoostSource source;
}
