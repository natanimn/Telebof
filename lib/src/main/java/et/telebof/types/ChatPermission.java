package et.telebof.types;

import java.io.Serializable;


public class ChatPermission implements Serializable {
    private Boolean can_send_messages, can_send_audios, can_send_documents, can_send_photos, can_send_videos,
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

    public Boolean getCanSendVoiceNotes() {
        return can_send_voice_notes;
    }

    public Boolean getCanSendPolls() {
        return can_send_polls;
    }

    public Boolean getCanSendVideos() {
        return can_send_videos;
    }

    public Boolean getCanSendVideoNotes() {
        return can_send_video_notes;
    }

    public Boolean getCanSendPhotos() {
        return can_send_photos;
    }

    public Boolean getCanSendOtherMessages() {
        return can_send_other_messages;
    }

    public Boolean getCanSendMessages() {
        return can_send_messages;
    }

    public Boolean getCanSendDocuments() {
        return can_send_documents;
    }

    public Boolean getCanSendAudios() {
        return can_send_audios;
    }

    public Boolean getCanAddWebPagePreviews() {
        return can_add_web_page_previews;
    }

    public Boolean getCanPinMessages() {
        return can_pin_messages;
    }

    public Boolean getCanManageTopics() {
        return can_manage_topics;
    }

    public Boolean getCanInviteUsers() {
        return can_invite_users;
    }

    public Boolean getCanChangeInfo() {
        return can_change_info;
    }


}
