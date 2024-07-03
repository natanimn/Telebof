package et.telebof.types;

import java.io.Serializable;
import java.util.List;

public class MessageReactionCountUpdated implements Serializable {
    public Chat chat;
    public int message_id;
    public int date;
    public List<ReactionCount> reactions;
}
