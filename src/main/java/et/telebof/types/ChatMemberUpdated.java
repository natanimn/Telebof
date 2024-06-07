package et.telebof.types;

public class ChatMemberUpdated {
    public Chat chat;
    public User from;
    public Integer date;
    public ChatMember old_chat_member, new_chat_member;
    public ChatInviteLink invite_link;
    public Boolean via_chat_folder_invite_link;

}
