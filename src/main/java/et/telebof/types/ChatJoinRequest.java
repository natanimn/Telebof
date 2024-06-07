package et.telebof.types;

import java.io.Serializable;

public class ChatJoinRequest implements Serializable {
    public Chat chat;
    public User from;
    public Long user_chat_id;
    public Integer date;
    public String bio;
    public ChatInviteLink invite_link;
}
