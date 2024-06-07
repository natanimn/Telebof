package et.telebof.types;

import java.io.Serializable;
import java.util.List;

/** Message class.
 * @author Natanim Negash
 */

public class Message extends JsonSerializable implements Serializable {
    public Integer message_id, message_thread_id, date, forward_from_message_id, forward_date, edit_date;
    public Long migrate_to_chat_id, migrate_from_chat_id;
    public String forward_signature, forward_sender_name, author_signature, text, caption,
            new_chat_title, connected_website, media_group_id;
    public User from, forward_from, via_bot, left_chat_member;
    public List<User> new_chat_members;
    public Chat sender_chat, chat, forward_from_chat;
    public Boolean is_topic, is_topic_message, is_automatic_forward, has_protected_content,
            has_media_spoiler, delete_chat_photo, group_chat_created, supergroup_chat_created, channel_chat_created;
    public Message reply_to_message, pinned_message;
    public List<MessageEntity> entities, caption_entities;
    public Animation animation;
    public Audio audio;
    public Document document;
    public List<PhotoSize> photo, new_chat_photo;
    public Sticker sticker;
    public Video video;
    public VideoNote video_note;
    public Voice voice;
    public Contact contact;
    public Dice dice;
    public Game game;
    public Poll poll;
    public Venue venue;
    public Location location;
    public Integer message_auto_delete_timer_changed;
    public Invoice invoice;
    public SuccessfulPayment successful_payment;
    public UserShared user_shared;
    public ChatShared chat_shared;
    public WriteAccessAllowed write_access_allowed;
    public PassportData passport_data;
    public ProximityAlertTriggered proximity_alert_triggered;
    public ForumTopicCreated forum_topic_created;
    public ForumTopicEdited forum_topic_edited;
    public ForumTopicClosed forum_topic_closed;
    public ForumTopicReopened forum_topic_reopened;
    public GeneralForumTopicHidden general_forum_topic_hidden;
    public GeneralForumTopicUnhidden general_forum_topic_unhidden;
    public VideoChatScheduled video_chat_scheduled;
    public VideoChatStarted video_chat_started;
    public VideoChatEnded video_chat_ended;
    public VideoChatParticipantsInvited video_chat_participants_invited;
    public WebAppData web_app_data;
    public InlineKeyboardMarkup reply_markup;

}
