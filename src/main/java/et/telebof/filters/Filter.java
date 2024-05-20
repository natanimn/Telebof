package et.telebof.filters;

import et.telebof.helpers.Util;
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
        this.TEXT = update.getMessage() !=null && update.getMessage().getText() != null;
        this.PRIVATE = chatType("private");
        this.CHANNEL = chatType("channel");
        this.GROUP = chatType("group");
        this.SUPERGROUP = chatType("supergroup");
        this.NON_PRIVATE = !PRIVATE;
        this.PHOTO = update.getMessage() !=null && update.getMessage().getPhoto() != null;
        this.AUDIO = update.getMessage() !=null && update.getMessage().getAudio() != null;
        this.VIDEO = update.getMessage() !=null && update.getMessage().getVideo() != null;
        this.VOICE = update.getMessage() !=null && update.getMessage().getVoice() != null;
        this.VIDEO_NOTE = update.getMessage() !=null && update.getMessage().getVideoNote() != null;
        this.DOCUMENT = update.getMessage() !=null && update.getMessage().getDocument() != null;
        this.ANIMATION = update.getMessage() !=null && update.getMessage().getAnimation() != null;
        this.CONTACT = update.getMessage() !=null && update.getMessage().getContact() != null;
        this.VENUE = update.getMessage() !=null && update.getMessage().getVenue() != null;
        this.LOCATION = update.getMessage() !=null && update.getMessage().getLocation() != null;
        this.STICKER = update.getMessage() !=null && update.getMessage().getSticker() != null;
        this.DICE = update.getMessage() !=null && update.getMessage().getDice() != null;
        this.GAME = update.getMessage() !=null && update.getMessage().getGame() != null;
        this.MEDIA = update.getMessage() !=null && (PHOTO || VIDEO || VOICE || VIDEO_NOTE || ANIMATION || STICKER || CONTACT ||
                                                DOCUMENT || VENUE || LOCATION || DICE);
        this.POLL = update.getMessage() != null && update.getMessage().getPoll() != null;
        this.NEW_CHAT_MEMBER = update.getMessage() !=null && update.getMessage().getNewChatMembers() != null;
        this.LEFT_CHAT_MEMBER = update.getMessage() !=null && update.getMessage().getLeftChatMember() != null;
        this.NEW_CHAT_PHOTO = update.getMessage() !=null && update.getMessage().getNewChatPhoto() != null;
        this.NEW_CHAT_TITLE = update.getMessage() !=null && update.getMessage().getNewChatTitle() != null;
        this.GROUP_CHAT_CREATED = update.getMessage() !=null && update.getMessage().getGroupChatCreated() != null;
        this.SUPERGROUP_CHAT_CREATED = update.getMessage() !=null && update.getMessage().getSupergroupChatCreated() != null;
        this.CHANNEL_CHAT_CREATED = update.getMessage() !=null && update.getMessage().getChannelChatCreated() != null;
        this.MESSAGE_AUTO_DELETE_TIMER_CHANGED = update.getMessage() !=null && update.getMessage().getMessageAutoDeleteTimerChanged() != null;
        this.MIGRATED = update.getMessage() !=null && (update.getMessage().getMigrateToChatId() != null || update.getMessage().getMigrateFromChatId() != null);
        this.PINNED_MESSAGE = update.getMessage() !=null && update.getMessage().getPinnedMessage() != null;
        this.INVOICE = update.getMessage() !=null && update.getMessage().getInvoice() != null;
        this.SUCCESSFUL_PAYMENT = update.getMessage() !=null && update.getMessage().getSuccessfulPayment() != null;
        this.CONNECTED_WEBSITE = update.getMessage() !=null && update.getMessage().getConnectedWebsite() != null;
        this.PASSPORT_DATA = update.getMessage() !=null && update.getMessage().getPassportData() != null;
        this.PROXIMITY_ALERT_TRIGGERED = update.getMessage() !=null && update.getMessage().getProximityAlertTriggered() != null;
        this.FORUM_TOPIC_CREATED = update.getMessage() !=null && update.getMessage().getForumTopicCreated() != null;
        this.FORUM_TOPIC_EDITED = update.getMessage() !=null && update.getMessage().getForumTopicEdited() != null;
        this.FORUM_TOPIC_CLOSED = update.getMessage() !=null && update.getMessage().getForumTopicClosed() != null;
        this.FORUM_TOPIC_REOPENED = update.getMessage() !=null && update.getMessage().getForumTopicReopened() != null;
        this.WEB_APP_DATA = update.getMessage() !=null && update.getMessage().getWebAppData() != null;
        this.VIDEO_CHAT_STARTED = update.getMessage() !=null && update.getMessage().getVideoChatStarted() != null;
        this.VIDEO_CHAT_PARTICIPANT_INVITED = update.getMessage() !=null && update.getMessage().getVideoChatParticipantsInvited() != null;
        this.VIDEO_CHAT_SCHEDULED = update.getMessage() !=null && update.getMessage().getVideoChatScheduled() != null;
        this.VIDEO_CHAT_ENDED = update.getMessage() !=null && update.getMessage().getVideoChatEnded() != null;
        this.FORWARDED = update.getMessage() !=null && (update.getMessage().getForwardFrom() != null || update.getMessage().getForwardFromChat() != null);
        this.REPLIED = update.getMessage() !=null && update.getMessage().getReplyToMessage() != null;
        this.BOT = update.getMessage() !=null && update.getMessage().getFrom().getIsBot();
        this.ZERO_INLINE_QUERY = update.getInlineQuery() != null && update.getInlineQuery().getQuery().isEmpty();
    }

    public boolean commands(String... commands){
       return List.of(commands).contains(Util.extractCommand(update.getMessage().getText()));
    }

    private boolean chatType(String chat){
        if (update.getMessage()!=null)return update.getMessage().getChat().getType().equals(chat);
        else if (update.getCallbackQuery() != null) return update.getCallbackQuery().getMessage().getChat().getType().equals(chat);
        else if (update.getEditedMessage() != null) return update.getEditedMessage().getChat().getType().equals(chat);
        else if (update.getInlineQuery() != null) return update.getInlineQuery().getChatType().equals(chat);
        else return false;
    }

    public boolean callbackData(String... callbacks){
        return List.of(callbacks).contains(update.getCallbackQuery().getData());
    }

    public boolean inlineQuery(String... queries){
        return List.of(queries).contains(update.getInlineQuery().getQuery());
    }

    public boolean customFilter(CustomFilter customFilter){
        return customFilter.check(update);
    }

    public boolean state(String name){
        Message message;
        User user;

        if (update.getMessage() != null) {
            message = update.getMessage();
            user = message.getFrom();
        }

        else if (update.getCallbackQuery() != null){
            message = update.getCallbackQuery().getMessage();
            user = update.getCallbackQuery().getFrom();
        }

        else return false;

        String chatStateName = storage.getName(message.getFrom().getId(), user.getId());
        String userStateName = storage.getName(user.getId());

        if (name.equals("*") && (chatStateName != null || userStateName != null)) return true;
        else if (chatStateName != null) return chatStateName.equals(name);
        else if (userStateName != null) return userStateName.equals(name);
        else return false;
    }

}
