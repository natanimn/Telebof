package et.telebof.types;


import java.io.Serializable;

public class ChatMember extends JsonSerializable implements Serializable {
    private String status, custom_title;
    private User user;

    private Boolean can_be_edited, is_anonymous, can_manage_chat, can_delete_messages, can_manage_video_chats,
            can_restrict_members, can_promote_members, can_change_info, can_invite_users,
            can_post_messages, can_edit_messages, can_pin_messages, can_manage_topics;

    private Boolean is_member, can_send_messages, can_send_audios, can_send_documents,
            can_send_photos, can_send_videos, can_send_video_notes, can_send_voice_votes, can_send_polls,
            can_send_other_messages, can_add_web_page_previews;

    private Integer until_date;


    public Boolean getIsAnonymous() {
        return is_anonymous;
    }

    public Boolean getCanBeEdited() {
        return can_be_edited;
    }

    public Boolean getCanManageChat() {
        return can_manage_chat;
    }

    public Boolean getCanManageVideoChats() {
        return can_manage_video_chats;
    }

    public Boolean getCanDeleteMessages() {
        return can_delete_messages;
    }

    public String getCustomTitle() {
        return custom_title;
    }

    public Boolean getCanRestrictMembers() {
        return can_restrict_members;
    }

    public String getStatus() {
        return status;
    }

    public User getUser() {
        return user;
    }

    public Boolean getCanAddWebPagePreviews() {
        return can_add_web_page_previews;
    }

    public Boolean getCanChangeInfo() {
        return can_change_info;
    }

    public Boolean getCanEditMessages() {
        return can_edit_messages;
    }

    public Boolean getCanInviteUsers() {
        return can_invite_users;
    }

    public Boolean getCanManageTopics() {
        return can_manage_topics;
    }

    public Boolean getCanPinMessages() {
        return can_pin_messages;
    }

    public Boolean getCanPostMessages() {
        return can_post_messages;
    }

    public Boolean getCanPromoteMembers() {
        return can_promote_members;
    }

    public Boolean getCanSendAudios() {
        return can_send_audios;
    }

    public Boolean getCanSendDocuments() {
        return can_send_documents;
    }

    public Boolean getCanSendMessages() {
        return can_send_messages;
    }

    public Boolean getCanSendOtherMessages() {
        return can_send_other_messages;
    }

    public Boolean getCanSendPhotos() {
        return can_send_photos;
    }

    public Boolean getIsMember() {
        return is_member;
    }

    public Boolean getCanSendPolls() {
        return can_send_polls;
    }

    public Boolean getCanSendVideoNotes() {
        return can_send_video_notes;
    }

    public Boolean getCanSendVideos() {
        return can_send_videos;
    }

    public Boolean getCanSendVoiceNotes() {
        return can_send_voice_votes;
    }

    public Integer getUntilDate() {
        return until_date;
    }
}








