package et.telebof.types;

import java.io.Serializable;

public class ChosenInlineResult implements Serializable {
    public String result_id;
    public User from;
    public Location location;
    public String inline_message_id, query;

}
