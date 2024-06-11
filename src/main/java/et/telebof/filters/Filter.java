package et.telebof.filters;

import et.telebof.Util;
import et.telebof.TelegramContext;
import et.telebof.types.Update;
import et.telebof.states.StateMemoryStorage;
import et.telebof.types.Message;
import et.telebof.types.User;

import java.util.List;

public class Filter{
    private final Update update;
    public final boolean TEXT;
    public final boolean PRIVATE;
    public final boolean GROUP;
    public final boolean SUPERGROUP;
    public final boolean CHANNEL;
    public final boolean NON_PRIVATE;
    public final boolean PHOTO;
    public final boolean VIDEO;
    public final boolean AUDIO;
    public final boolean VENUE;
    public final boolean VOICE;
    public final boolean STICKER;
    public final boolean ANIMATION;
    public final boolean DICE;
    public final boolean VIDEO_NOTE;
    public final boolean DOCUMENT;
    public final boolean GAME;
    public final boolean CONTACT;
    public final boolean LOCATION;
    public final boolean MEDIA;
    public final boolean NEW_CHAT_MEMBER;
    public final boolean LEFT_CHAT_MEMBER;
    public final boolean NEW_CHAT_PHOTO;
    public final boolean NEW_CHAT_TITLE;
    public final boolean SUPERGROUP_CHAT_CREATED;
    public final boolean GROUP_CHAT_CREATED;
    public final boolean CHANNEL_CHAT_CREATED;
    public final boolean MESSAGE_AUTO_DELETE_TIMER_CHANGED;
    public final boolean MIGRATED;
    public final boolean PINNED_MESSAGE;
    public final boolean INVOICE;
    public final boolean SUCCESSFUL_PAYMENT;
    public final boolean CONNECTED_WEBSITE;
    public final boolean PASSPORT_DATA;
    public final boolean PROXIMITY_ALERT_TRIGGERED;
    public final boolean FORUM_TOPIC_CREATED;
    public final boolean FORUM_TOPIC_CLOSED;
    public final boolean FORUM_TOPIC_EDITED;
    public final boolean FORUM_TOPIC_REOPENED;
    public final boolean VIDEO_CHAT_STARTED;
    public final boolean VIDEO_CHAT_ENDED;
    public final boolean VIDEO_CHAT_PARTICIPANT_INVITED;
    public final boolean VIDEO_CHAT_SCHEDULED;
    public final boolean WEB_APP_DATA;
    public final boolean FORWARDED;
    public final boolean REPLIED;
    public final boolean BOT;
    public final boolean POLL;
    public final boolean ZERO_INLINE_QUERY;
    public final TelegramContext context;
    private final StateMemoryStorage storage;
    public Filter(Update update, TelegramContext context, StateMemoryStorage storage){
        this.update = update;
        this.context = context;
        this.storage = storage;
        this.TEXT = update.message !=null && update.message.text != null;
        this.PRIVATE = chatType("private");
        this.CHANNEL = chatType("channel");
        this.GROUP = chatType("group");
        this.SUPERGROUP = chatType("supergroup");
        this.NON_PRIVATE = !PRIVATE;
        this.PHOTO = update.message !=null && update.message.poll != null;
        this.AUDIO = update.message !=null && update.message.audio != null;
        this.VIDEO = update.message !=null && update.message.video != null;
        this.VOICE = update.message !=null && update.message.venue != null;
        this.VIDEO_NOTE = update.message !=null && update.message.video_note != null;
        this.DOCUMENT = update.message !=null && update.message.document != null;
        this.ANIMATION = update.message !=null && update.message.animation != null;
        this.CONTACT = update.message !=null && update.message.contact != null;
        this.VENUE = update.message !=null && update.message.venue != null;
        this.LOCATION = update.message !=null && update.message.location != null;
        this.STICKER = update.message !=null && update.message.sticker != null;
        this.DICE = update.message !=null && update.message.dice != null;
        this.GAME = update.message !=null && update.message.game != null;
        this.MEDIA = update.message !=null && (PHOTO || VIDEO || VOICE || VIDEO_NOTE || ANIMATION || STICKER || DOCUMENT );
        this.POLL = update.message != null && update.message.poll != null;
        this.NEW_CHAT_MEMBER = update.message !=null && update.message.new_chat_members != null;
        this.LEFT_CHAT_MEMBER = update.message !=null && update.message.left_chat_member != null;
        this.NEW_CHAT_PHOTO = update.message !=null && update.message.new_chat_photo != null;
        this.NEW_CHAT_TITLE = update.message !=null && update.message.new_chat_title != null;
        this.GROUP_CHAT_CREATED = update.message !=null && update.message.group_chat_created != null;
        this.SUPERGROUP_CHAT_CREATED = update.message !=null && update.message.supergroup_chat_created != null;
        this.CHANNEL_CHAT_CREATED = update.message !=null && update.message.channel_chat_created != null;
        this.MESSAGE_AUTO_DELETE_TIMER_CHANGED = update.message !=null && update.message.message_auto_delete_timer_changed != null;
        this.MIGRATED = update.message !=null && (update.message.migrate_to_chat_id != null || update.message.migrate_from_chat_id != null);
        this.PINNED_MESSAGE = update.message !=null && update.message.pinned_message != null;
        this.INVOICE = update.message !=null && update.message.invoice != null;
        this.SUCCESSFUL_PAYMENT = update.message !=null && update.message.successful_payment != null;
        this.CONNECTED_WEBSITE = update.message !=null && update.message.connected_website != null;
        this.PASSPORT_DATA = update.message !=null && update.message.passport_data != null;
        this.PROXIMITY_ALERT_TRIGGERED = update.message !=null && update.message.proximity_alert_triggered != null;
        this.FORUM_TOPIC_CREATED = update.message !=null && update.message.forum_topic_created != null;
        this.FORUM_TOPIC_EDITED = update.message !=null && update.message.forum_topic_edited != null;
        this.FORUM_TOPIC_CLOSED = update.message !=null && update.message.forum_topic_closed != null;
        this.FORUM_TOPIC_REOPENED = update.message !=null && update.message.forum_topic_reopened != null;
        this.WEB_APP_DATA = update.message !=null && update.message.web_app_data != null;
        this.VIDEO_CHAT_STARTED = update.message !=null && update.message.video_chat_started != null;
        this.VIDEO_CHAT_PARTICIPANT_INVITED = update.message !=null && update.message.video_chat_participants_invited != null;
        this.VIDEO_CHAT_SCHEDULED = update.message !=null && update.message.video_chat_scheduled != null;
        this.VIDEO_CHAT_ENDED = update.message !=null && update.message.video_chat_ended != null;
        this.FORWARDED = update.message !=null && (update.message.forward_from != null || update.message.forward_from_chat != null);
        this.REPLIED = update.message !=null && update.message.reply_to_message != null;
        this.BOT = update.message !=null && update.message.from.is_bot;
        this.ZERO_INLINE_QUERY = update.inline_query != null && update.inline_query.query.isEmpty();
    }

    public boolean commands(String... commands){
        String command = Util.extractCommand(update.message.text);
        if (command == null) return false;
        return List.of(commands).contains(command);
    }

    private boolean chatType(String chat){
        if (update.message!=null)return update.message.chat.type.equals(chat);
        else if (update.callback_query != null) return update.callback_query.message.chat.type.equals(chat);
        else if (update.edited_message != null) return update.edited_message.chat.type.equals(chat);
        else if (update.inline_query != null) return update.inline_query.chat_type.equals(chat);
        else return false;
    }

    public boolean callbackData(String... callbacks){
        if (update.callback_query == null) return false;
        String data = update.callback_query.data;
        if (data == null) return false;
        return List.of(callbacks).contains(data);
    }

    public boolean inlineQuery(String... queries){
        if (update.inline_query == null) return false;
        String query = update.inline_query.query;
        if (query == null) return false;
        return List.of(queries).contains(query);
    }

    public boolean customFilter(CustomFilter customFilter){
        return customFilter.check(update);
    }

    public boolean state(String name){
        Message message;
        User user;

        if (update.message != null) {
            message = update.message;
            user = message.from;
        }

        else if (update.callback_query != null){
            message = update.callback_query.message;
            user = update.callback_query.from;
        }

        else return false;

        String chatStateName = storage.getName(message.from.id, user.id);
        String userStateName = storage.getName(user.id);

        if (name.equals("*") && (chatStateName != null || userStateName != null)) return true;
        else if (chatStateName != null) return chatStateName.equals(name);
        else if (userStateName != null) return userStateName.equals(name);
        else return false;
    }

}
