package et.telebof.types;

import java.io.Serializable;

public class ChosenInlineResult implements Serializable {
    private String result_id;
    private User from;
    private Location location;
    private String inline_message_id, query;

    public Location getLocation() {
        return location;
    }

    public User getFrom() {
        return from;
    }

    public String getResultId() {
        return result_id;
    }

    public String getInlineMessageId() {
        return inline_message_id;
    }

    public String getQuery() {
        return query;
    }

}
