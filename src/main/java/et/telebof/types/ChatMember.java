package et.telebof.types;


import java.io.Serializable;

public class ChatMember extends JsonSerializable implements Serializable {
    public String status, custom_title;
    public User user;

    public Boolean can_be_edited, is_anonymous, can_manage_chat, can_delete_messages, can_manage_video_chats,
            can_restrict_members, can_promote_members, can_change_info, can_invite_users,
            can_post_messages, can_edit_messages, can_pin_messages, can_manage_topics;

    public Boolean is_member, can_send_messages, can_send_audios, can_send_documents,
            can_send_photos, can_send_videos, can_send_video_notes, can_send_voice_votes, can_send_polls,
            can_send_other_messages, can_add_web_page_previews;

    public Boolean can_post_stories, can_edit_stories, can_delete_stories;

    public Integer until_date;

}








