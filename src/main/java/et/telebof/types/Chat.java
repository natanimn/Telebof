package et.telebof.types;

import java.io.Serializable;
import java.util.List;

public class Chat extends JsonSerializable  implements Serializable {

    public long id;
    public String type, title, username, first_name, last_name;
    public Boolean is_forum;
    public ChatPhoto photo;
    public List<String> active_usernames;
    public String emoji_status_custom_emoji_id, bio;
    public Boolean has_private_forwards, has_restricted_voice_and_video_messages, join_to_send_messages, join_by_request;
    public String description, invite_link;
    public Message pinned_message;
    public ChatPermission permissions;
    public Integer slow_mode_delay, message_auto_delete_time;
    public Boolean has_aggressive_anti_spam_enabled, has_hidden_members, has_protected_content;
    public String sticker_set_name;
    public Boolean can_set_sticker_set;
    public Integer linked_chat_id;
    public Location location;

}
