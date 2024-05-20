package et.telebof.types;

import java.io.Serializable;
import java.util.List;

/** Message class.
 * @author Natanim Negash
 */

public class Message extends JsonSerializable implements Serializable {
    private Integer message_id, message_thread_id, date, forward_from_message_id, forward_date, edit_date;
    private Long migrate_to_chat_id, migrate_from_chat_id;
    private String forward_signature, forward_sender_name, author_signature, text, caption,
            new_chat_title, connected_website, media_group_id;
    private User from, forward_from, via_bot, left_chat_member;
    private List<User> new_chat_members;
    private Chat sender_chat, chat, forward_from_chat;
    private Boolean is_topic, is_topic_message, is_automatic_forward, has_protected_content,
            has_media_spoiler, delete_chat_photo, group_chat_created, supergroup_chat_created, channel_chat_created;
    private Message reply_to_message, pinned_message;
    private List<MessageEntity> entities, caption_entities;
    private Animation animation;
    private Audio audio;
    private Document document;
    private List<PhotoSize> photo, new_chat_photo;
    private Sticker sticker;
    private Video video;
    private VideoNote video_note;
    private Voice voice;
    private Contact contact;
    private Dice dice;
    private Game game;
    private Poll poll;
    private Venue venue;
    private Location location;
    private Integer message_auto_delete_timer_changed;
    private Invoice invoice;
    private SuccessfulPayment successful_payment;
    private UserShared user_shared;
    private ChatShared chat_shared;
    private WriteAccessAllowed write_access_allowed;
    private PassportData passport_data;
    private ProximityAlertTriggered proximity_alert_triggered;
    private ForumTopicCreated forum_topic_created;
    private ForumTopicEdited forum_topic_edited;
    private ForumTopicClosed forum_topic_closed;
    private ForumTopicReopened forum_topic_reopened;
    private GeneralForumTopicHidden general_forum_topic_hidden;
    private GeneralForumTopicUnhidden general_forum_topic_unhidden;
    private VideoChatScheduled video_chat_scheduled;
    private VideoChatStarted video_chat_started;
    private VideoChatEnded video_chat_ended;
    private VideoChatParticipantsInvited video_chat_participants_invited;
    private WebAppData web_app_data;
    private InlineKeyboardMarkup reply_markup;

    public String mention(){
        // Do not forget to set parseMode to ParseMode.HTML
        String name = from.getFirstName() + (from.getLastName() != null ? from.getLastName() : "");
        return String.format("<a href='tg://user?id=%d'>%s</a>", from.getId(), name);
    }

    public Integer getMessageId() {
        return message_id;
    }

    public Integer getMessageThreadId() {
        return message_thread_id;
    }

    public Integer getDate() {
        return date;
    }

    public Integer getForwardFromMessageId() {
        return forward_from_message_id;
    }

    public Integer getForwardDate() {
        return forward_date;
    }

    public Integer getEditDate() {
        return edit_date;
    }

    public Long getMigrateToChatId() {
        return migrate_to_chat_id;
    }

    public Long getMigrateFromChatId() {
        return migrate_from_chat_id;
    }

    public String getForwardSignature() {
        return forward_signature;
    }

    public String getForwardSenderName() {
        return forward_sender_name;
    }

    public String getAuthorSignature() {
        return author_signature;
    }

    public String getText() {
        return text;
    }

    public String getCaption() {
        return caption;
    }

    public String getNewChatTitle() {
        return new_chat_title;
    }

    public String getConnectedWebsite() {
        return connected_website;
    }

    public String getMediaGroupId() {
        return media_group_id;
    }

    public User getFrom() {
        return from;
    }

    public User getForwardFrom() {
        return forward_from;
    }

    public User getViaBot() {
        return via_bot;
    }

    public User getLeftChatMember() {
        return left_chat_member;
    }

    public List<User> getNewChatMembers() {
        return new_chat_members;
    }

    public Chat getSenderChat() {
        return sender_chat;
    }

    public Chat getChat() {
        return chat;
    }

    public Chat getForwardFromChat() {
        return forward_from_chat;
    }

    public Boolean getIsTopic() {
        return is_topic;
    }

    public Boolean getIsTopicMessage() {
        return is_topic_message;
    }

    public Boolean getAutomaticForward() {
        return is_automatic_forward;
    }

    public Boolean getHasProtectedContent() {
        return has_protected_content;
    }

    public Boolean getHasMediaSpoiler() {
        return has_media_spoiler;
    }

    public Boolean getDeleteChatPhoto() {
        return delete_chat_photo;
    }

    public Boolean getGroupChatCreated() {
        return group_chat_created;
    }

    public Boolean getSupergroupChatCreated() {
        return supergroup_chat_created;
    }

    public Boolean getChannelChatCreated() {
        return channel_chat_created;
    }

    public Message getReplyToMessage() {
        return reply_to_message;
    }

    public Message getPinnedMessage() {
        return pinned_message;
    }

    public List<MessageEntity> getEntities() {
        return entities;
    }

    public List<MessageEntity> getCaptionEntities() {
        return caption_entities;
    }

    public Animation getAnimation() {
        return animation;
    }

    public Audio getAudio() {
        return audio;
    }

    public Document getDocument() {
        return document;
    }

    public List<PhotoSize> getPhoto() {
        return photo;
    }

    public List<PhotoSize> getNewChatPhoto() {
        return new_chat_photo;
    }

    public Sticker getSticker() {
        return sticker;
    }

    public Video getVideo() {
        return video;
    }

    public VideoNote getVideoNote() {
        return video_note;
    }

    public Voice getVoice() {
        return voice;
    }

    public Contact getContact() {
        return contact;
    }

    public Dice getDice() {
        return dice;
    }

    public Game getGame() {
        return game;
    }

    public Poll getPoll() {
        return poll;
    }

    public Venue getVenue() {
        return venue;
    }

    public Location getLocation() {
        return location;
    }

    public Integer getMessageAutoDeleteTimerChanged() {
        return message_auto_delete_timer_changed;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public SuccessfulPayment getSuccessfulPayment() {
        return successful_payment;
    }

    public UserShared getUserShared() {
        return user_shared;
    }

    public ChatShared getChatShared() {
        return chat_shared;
    }

    public WriteAccessAllowed getWriteAccessAllowed() {
        return write_access_allowed;
    }

    public PassportData getPassportData() {
        return passport_data;
    }

    public ProximityAlertTriggered getProximityAlertTriggered() {
        return proximity_alert_triggered;
    }

    public ForumTopicCreated getForumTopicCreated() {
        return forum_topic_created;
    }

    public ForumTopicEdited getForumTopicEdited() {
        return forum_topic_edited;
    }

    public ForumTopicClosed getForumTopicClosed() {
        return forum_topic_closed;
    }

    public ForumTopicReopened getForumTopicReopened() {
        return forum_topic_reopened;
    }

    public GeneralForumTopicHidden getGeneralForumTopicHidden() {
        return general_forum_topic_hidden;
    }

    public GeneralForumTopicUnhidden getGeneralForumTopicUnhidden() {
        return general_forum_topic_unhidden;
    }

    public VideoChatScheduled getVideoChatScheduled() {
        return video_chat_scheduled;
    }

    public VideoChatStarted getVideoChatStarted() {
        return video_chat_started;
    }

    public VideoChatEnded getVideoChatEnded() {
        return video_chat_ended;
    }

    public VideoChatParticipantsInvited getVideoChatParticipantsInvited() {
        return video_chat_participants_invited;
    }

    public WebAppData getWebAppData() {
        return web_app_data;
    }

    public InlineKeyboardMarkup getReplyMarkup() {
        return reply_markup;
    }


}
