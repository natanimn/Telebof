package et.telebof.types;

import java.io.Serializable;
import java.util.List;

public class Chat extends JsonSerializable  implements Serializable {

    private long id;
    private String type, title, username, first_name, last_name;
    private Boolean is_forum;
    private ChatPhoto photo;
    private List<String> active_usernames;
    private String emoji_status_custom_emoji_id, bio;
    private Boolean has_private_forwards, has_restricted_voice_and_video_messages, join_to_send_messages, join_by_request;
    private String description, invite_link;
    private Message pinned_message;
    private ChatPermission permissions;
    private Integer slow_mode_delay, message_auto_delete_time;
    private Boolean has_aggressive_anti_spam_enabled, has_hidden_members, has_protected_content;
    private String sticker_set_name;
    private Boolean can_set_sticker_set;
    private Integer linked_chat_id;
    private Location location;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public ChatPhoto getPhoto() {
        return photo;
    }

    public Boolean getIsForum() {
        return is_forum;
    }

    public String getFirstName() {
        return first_name;
    }

    public List<String> getActiveUsernames() {
        return active_usernames;
    }

    public String getLastName() {
        return last_name;
    }

    public String getType() {
        return type;
    }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getCanSetStickerSet() {
        return can_set_sticker_set;
    }

    public Boolean getHasAggressiveAntiSpamEnabled() {
        return has_aggressive_anti_spam_enabled;
    }

    public Boolean getHasHiddenMembers() {
        return has_hidden_members;
    }

    public Boolean getHasPrivateForwards() {
        return has_private_forwards;
    }

    public Boolean getHasProtectedContent() {
        return has_protected_content;
    }

    public Boolean getJoinByRequest() {
        return join_by_request;
    }

    public ChatPermission getPermissions() {
        return permissions;
    }

    public Integer getLinkedChatId() {
        return linked_chat_id;
    }

    public Boolean getHasRestrictedVoiceAndVideoMessages() {
        return has_restricted_voice_and_video_messages;
    }

    public Boolean getJoinToSendMessages() {
        return join_to_send_messages;
    }

    public Integer getMessageAutoDeleteTime() {
        return message_auto_delete_time;
    }

    public Integer getSlowModeDelay() {
        return slow_mode_delay;
    }

    public Location getLocation() {
        return location;
    }

    public Message getPinnedMessage() {
        return pinned_message;
    }

    public String getBio() {
        return bio;
    }

    public String getEmojiStatusCustomEmojiId() {
        return emoji_status_custom_emoji_id;
    }

    public String getInviteLink() {
        return invite_link;
    }

    public String getStickerSetName(){
        return sticker_set_name;
    }
}
