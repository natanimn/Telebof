package et.telebof.types;

import java.io.Serializable;


public class ChatAdministratorRights implements Serializable {
    private Boolean is_anonymous, can_manage_chat, can_delete_messages, can_manage_video_chats,
            can_restrict_members, can_promote_members, can_change_info, can_invite_users,
            can_post_messages, can_edit_messages, can_pin_messages, can_manage_topics;

    private ChatAdministratorRights add(String key, boolean value) {
        return this;
    }

    public ChatAdministratorRights isAnonymous(boolean isAnonymous) {
        this.is_anonymous = isAnonymous;
        return add("is_anonymous", isAnonymous);
    }

    public ChatAdministratorRights canManageChat(boolean canManageChat) {
        this.can_manage_chat = canManageChat;
        return add("can_manage_chat", canManageChat);
    }

    public ChatAdministratorRights canPostMessages(boolean canPostMessages) {
        this.can_post_messages = canPostMessages;
        return add("can_post_messages", canPostMessages);
    }

    public ChatAdministratorRights canEditMessages(boolean canEditMessages) {
        this.can_edit_messages = canEditMessages;
        return add("can_edit_messages", canEditMessages);
    }

    public ChatAdministratorRights canDeleteMessages(boolean canDeleteMessages) {
        this.can_delete_messages = canDeleteMessages;
        return add("can_delete_messages", canDeleteMessages);
    }

    public ChatAdministratorRights canManageVideoChats(boolean canManageVideoChats) {
        this.can_manage_video_chats = canManageVideoChats;
        return add("can_manage_video_chats", canManageVideoChats);
    }

    public ChatAdministratorRights canRestrictMembers(boolean canRestrictMembers) {
        this.can_restrict_members = canRestrictMembers;
        return add("can_restrict_members", canRestrictMembers);
    }

    public ChatAdministratorRights canPromoteMembers(boolean canPromoteMembers) {
        this.can_promote_members = canPromoteMembers;
        return add("can_promote_members", canPromoteMembers);
    }

    public ChatAdministratorRights canChangeInfo(boolean canChangeInfo) {
        this.can_change_info = canChangeInfo;
        return add("can_change_info", canChangeInfo);
    }

    public ChatAdministratorRights canInviteUsers(boolean canInviteUsers) {
        this.can_invite_users = canInviteUsers;
        return add("can_invite_users", canInviteUsers);
    }

    public ChatAdministratorRights canPinMessages(boolean canPinMessages) {
        this.can_pin_messages = canPinMessages;
        return add("can_pin_messages", canPinMessages);
    }

    public ChatAdministratorRights canManageTopics(boolean canManageTopics) {
        this.can_manage_topics = canManageTopics;
        return add("can_manage_topics", canManageTopics);
    }

    public Boolean getCanChangeInfo() {
        return can_change_info;
    }

    public Boolean getCanDeleteMessages() {
        return can_delete_messages;
    }

    public Boolean getCanManageChat() {
        return can_manage_chat;
    }

    public Boolean getCanManageVideoChats() {
        return can_manage_video_chats;
    }

    public Boolean getCanEditMessages() {
        return can_edit_messages;
    }

    public Boolean getCanPinMessages() {
        return can_pin_messages;
    }

    public Boolean getCanPromoteMembers() {
        return can_promote_members;
    }

    public Boolean getCanRestrictMembers() {
        return can_restrict_members;
    }

    public Boolean getCanInviteUsers() {
        return can_invite_users;
    }

    public Boolean getCanPostMessages() {
        return can_post_messages;
    }

    public Boolean getIsAnonymous() {
        return is_anonymous;
    }

    public Boolean getCanManageTopics() {
        return can_manage_topics;
    }
}
