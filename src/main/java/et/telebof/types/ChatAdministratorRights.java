package et.telebof.types;

import java.io.Serializable;


public class ChatAdministratorRights implements Serializable {
    public Boolean is_anonymous, can_manage_chat, can_delete_messages, can_manage_video_chats,
            can_restrict_members, can_promote_members, can_change_info, can_invite_users,
            can_post_messages, can_edit_messages, can_pin_messages, can_manage_topics,
            can_post_stories, can_edit_stories, can_delete_stories;

    public ChatAdministratorRights isAnonymous(boolean isAnonymous) {
        this.is_anonymous = isAnonymous;
        return this;
    }

    public ChatAdministratorRights canManageChat(boolean canManageChat) {
        this.can_manage_chat = canManageChat;
        return this;
    }

    public ChatAdministratorRights canPostMessages(boolean canPostMessages) {
        this.can_post_messages = canPostMessages;
        return this;
    }

    public ChatAdministratorRights canEditMessages(boolean canEditMessages) {
        this.can_edit_messages = canEditMessages;
        return this;
    }

    public ChatAdministratorRights canDeleteMessages(boolean canDeleteMessages) {
        this.can_delete_messages = canDeleteMessages;
        return this;
    }

    public ChatAdministratorRights canManageVideoChats(boolean canManageVideoChats) {
        this.can_manage_video_chats = canManageVideoChats;
        return this;
    }

    public ChatAdministratorRights canRestrictMembers(boolean canRestrictMembers) {
        this.can_restrict_members = canRestrictMembers;
        return this;
    }

    public ChatAdministratorRights canPromoteMembers(boolean canPromoteMembers) {
        this.can_promote_members = canPromoteMembers;
        return this;
    }

    public ChatAdministratorRights canChangeInfo(boolean canChangeInfo) {
        this.can_change_info = canChangeInfo;
        return this;
    }

    public ChatAdministratorRights canInviteUsers(boolean canInviteUsers) {
        this.can_invite_users = canInviteUsers;
        return this;
    }

    public ChatAdministratorRights canPinMessages(boolean canPinMessages) {
        this.can_pin_messages = canPinMessages;
        return this;
    }

    public ChatAdministratorRights canManageTopics(boolean canManageTopics) {
        this.can_manage_topics = canManageTopics;
        return this;
    }

    public ChatAdministratorRights canPostStories(boolean canPostStories){
        this.can_post_stories = canPostStories;
        return this;
    }

    public ChatAdministratorRights canEditStories(boolean canEditStories){
        this.can_edit_stories = canEditStories;
        return this;
    }

    public ChatAdministratorRights canDeleteStories(boolean can_delete_stories){
        this.can_delete_stories = can_delete_stories;
        return this;
    }

}
