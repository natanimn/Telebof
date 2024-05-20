package et.telebof.types;

import java.io.Serializable;

public class ChatJoinRequest implements Serializable {
    private Chat chat;
    private User from;
    private Long user_chat_id;
    private Integer date;
    private String bio;
    private ChatInviteLink invite_link;

    public Chat getChat() {
        return chat;
    }

    public User getFrom() {
        return from;
    }

    public String getBio() {
        return bio;
    }

    public Long getUserChatId() {
        return user_chat_id;
    }

    public Integer getDate() {
        return date;
    }

    public ChatInviteLink getInviteLink() {
        return invite_link;
    }

}
