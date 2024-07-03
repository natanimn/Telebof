package et.telebof.types;

import java.io.Serializable;
import java.util.List;

public class MessageReactionUpdated implements Serializable {
    public Chat chat;
    public int message_id;
    public User user;
    public Chat actor_chat;
    public int date;
    public List<ReactionType> old_reaction;
    public List<ReactionType> new_reaction;
}
