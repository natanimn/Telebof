package et.telebof.types;

public class ChatMemberUpdated {
    private Chat chat;
    private User from;
    private Integer date;
    private ChatMember old_chat_member, new_chat_member;
    private ChatInviteLink invite_link;

    public Chat getChat() {
        return chat;
    }

    public User getFrom() {
        return from;
    }

    public Integer getDate() {
        return date;
    }

    public ChatMember getOldChatMember() {
        return old_chat_member;
    }

    public ChatMember getNewChatMember() {
        return new_chat_member;
    }

    public ChatInviteLink getInviteLink() {
        return invite_link;
    }
}
