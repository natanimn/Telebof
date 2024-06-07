package et.telebof.types;

import java.io.Serializable;


public class ChatPermission implements Serializable {
    public Boolean can_send_messages, can_send_audios, can_send_documents, can_send_photos, can_send_videos,
            can_send_video_notes, can_send_voice_notes, can_send_polls, can_send_other_messages, can_add_web_page_previews,
            can_change_info, can_invite_users, can_pin_messages, can_manage_topics;
    public ChatPermission canSendMessages(boolean canSendMessages) {
        this.can_send_messages = canSendMessages;
        return this;
    }

    public ChatPermission canSendAudios(boolean canSendAudios) {
        this.can_send_audios = canSendAudios;
        return this;
    }

    public ChatPermission canSendDocuments(boolean canSendDocuments) {
        this.can_send_documents = canSendDocuments;
        return this;
    }

    public ChatPermission canSendPhotos(boolean canSendPhotos) {
        this.can_send_photos = canSendPhotos;
        return this;
    }

    public ChatPermission canSendVideos(boolean canSendVideos) {
        this.can_send_videos = canSendVideos;
        return this;
    }

    public ChatPermission canSendVideoNotes(boolean canSendVideoNotes) {
        this.can_send_video_notes = canSendVideoNotes;
        return this;
    }

    public ChatPermission canSendVoiceNotes(boolean canSendVoiceNotes) {
        this.can_send_voice_notes = canSendVoiceNotes;
        return this;
    }

    public ChatPermission canSendPolls(boolean canSendPolls) {
        this.can_send_polls = canSendPolls;
        return this;
    }

    public ChatPermission canSendOtherMessages(boolean canSendOtherMessages) {
        this.can_send_other_messages = canSendOtherMessages;
        return this;
    }

    public ChatPermission canAddWebPagePreviews(boolean canAddWebPagePreviews) {
        this.can_add_web_page_previews = canAddWebPagePreviews;
        return this;
    }

    public ChatPermission canChangeInfo(boolean canChangeInfo) {
        this.can_change_info = canChangeInfo;
        return this;
    }

    public ChatPermission canInviteUsers(boolean canInviteUsers) {
        this.can_invite_users = canInviteUsers;
        return this;
    }

    public ChatPermission canPinMessages(boolean canPinMessages) {
        this.can_pin_messages = canPinMessages;
        return this;
    }

    public ChatPermission canManageTopics(boolean canManageTopics) {
        this.can_manage_topics = canManageTopics;
        return this;
    }

}
