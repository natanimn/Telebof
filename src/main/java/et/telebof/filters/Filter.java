package et.telebof.filters;

import et.telebof.Util;
import et.telebof.types.Update;
import et.telebof.states.StateMemoryStorage;
import et.telebof.types.Message;
import et.telebof.types.User;
import java.util.List;

public class Filter{
    private final Update update;
    private final StateMemoryStorage storage;

    public Filter(Update update, StateMemoryStorage storage){
        this.update = update;
        this.storage = storage;
    }

    public Boolean text(){
        return update.message !=null && update.message.text != null;
    }

    public Boolean privateChat(){
        return chatType("private");
    }

    public Boolean channel(){
        return chatType("channel");
    }

    public Boolean supergroup(){
        return chatType("supergroup");
    }

    public Boolean group(){
        return chatType("group");
    }

    public Boolean photo(){
        return update.message !=null && update.message.photo != null;
    }

    public Boolean video(){
        return update.message !=null && update.message.video != null;
    }

    public Boolean voice(){
        return update.message !=null && update.message.voice != null;
    }

    public Boolean document(){
        return update.message !=null && update.message.document != null;
    }

    public Boolean videoNote(){
        return update.message !=null && update.message.video_note != null;
    }

    public Boolean animation(){
        return update.message !=null && update.message.animation != null;
    }

    public Boolean contact(){
        return update.message !=null && update.message.contact != null;
    }

    public Boolean location(){
        return update.message !=null && update.message.location != null;
    }

    public Boolean venue(){
        return update.message !=null && update.message.venue != null;
    }

    public Boolean game(){
        return update.message !=null && update.message.game != null;
    }

    public Boolean dice(){
        return update.message !=null && update.message.dice != null;
    }

    public Boolean sticker(){
        return update.message !=null && update.message.poll != null;
    }

    public Boolean audio(){
        return update.message !=null && update.message.audio != null;
    }

    public Boolean invoice(){
        return update.message !=null && update.message.invoice != null;
    }

    public Boolean quote(){
        return update.message !=null && update.message.quote != null;
    }

    public Boolean giveaway(){
        return update.message !=null && update.message.giveaway != null;
    }

    public Boolean media(){
        return update.message !=null && (photo() || video() || videoNote() || sticker() || audio() || animation() || document() || voice());
    }

    public Boolean newChatMember(){
        return update.message !=null && update.message.new_chat_members != null;
    }

    public Boolean leftChatMember(){
        return update.message !=null && update.message.left_chat_member != null;
    }

    public Boolean pinnedMessage(){
        return update.message !=null && update.message.pinned_message != null;
    }

    public Boolean newChatPhoto(){
        return update.message !=null && update.message.new_chat_photo != null;
    }

    public Boolean newChatTitle(){
        return update.message !=null && update.message.new_chat_title != null;
    }

    public Boolean newChat(){
        return update.message !=null && update.message.new_chat_members != null;
    }

    public Boolean groupCreated(){
        return update.message !=null && update.message.group_chat_created != null;
    }

    public Boolean supergroupCreated(){
        return update.message !=null && update.message.supergroup_chat_created != null;
    }

    public Boolean channelCreated(){
        return update.message !=null && update.message.channel_chat_created != null;
    }

    public Boolean messageAutoDeleteTimerChanged(){
        return update.message !=null && update.message.message_auto_delete_timer_changed != null;
    }

    public Boolean migrated(){
        return update.message !=null && (update.message.migrate_to_chat_id != null || update.message.migrate_from_chat_id != null);
    }

    public Boolean successfulPayment() {
        return update.message != null && update.message.successful_payment != null;
    }

    public Boolean proximityAlertTriggered() {
        return update.message != null && update.message.proximity_alert_triggered != null;
    }

    public Boolean forumTopicCreated() {
        return update.message != null && update.message.forum_topic_edited != null;
    }

    public Boolean forumTopicEdited() {
        return update.message != null && update.message.forum_topic_edited != null;
    }

    public Boolean forumTopicClosed() {
        return update.message != null && update.message.forum_topic_closed != null;
    }


    public Boolean forumTopicReopened() {
        return update.message != null && update.message.forum_topic_reopened != null;
    }

    public Boolean videoChatStarted() {
        return update.message != null && update.message.video_chat_started != null;
    }

    public Boolean videoChatScheduled() {
        return update.message != null && update.message.video_chat_scheduled != null;
    }

    public Boolean videoChatParticipantInvited() {
        return update.message != null && update.message.video_chat_participants_invited != null;
    }

    public Boolean videoChatEnded() {
        return update.message != null && update.message.video_chat_ended != null;
    }

    public Boolean forwarded() {
        return update.message != null && update.message.forward_origin != null;
    }

    public Boolean replied() {
        return update.message != null && update.message.reply_to_message != null;
    }

    public Boolean repliedToStory() {
        return update.message != null && update.message.reply_to_story != null;
    }

    public Boolean bot() {
        return update.message != null && update.message.from.is_bot != null;
    }

    public Boolean giveawayCreated() {
        return update.message != null && update.message.giveaway_created != null;
    }

    public Boolean giveawayCompleted() {
        return update.message != null && update.message.giveaway_completed != null;
    }

    public Boolean boostAdded() {
        return update.message != null && update.message.boost_added != null;
    }

    public Boolean usersShared() {
        return update.message != null && update.message.users_shared != null;
    }

    public Boolean writeAccessAllowed() {
        return update.message != null && update.message.write_access_allowed != null;
    }

    public Boolean entities() {
        return update.message != null && update.message.entities != null;
    }

    public Boolean chatBackgroundSet() {
        return update.message != null && update.message.chat_background_set != null;
    }

    public Boolean chatShared() {
        return update.message != null && update.message.chat_shared != null;
    }

    public Boolean emptyQuery(){
        return update.inline_query != null && update.inline_query.query.isEmpty();
    }

    public Boolean webAppData(){
        return update.message != null && update.message.web_app_data != null;
    }

    public Boolean passportData(){
        return update.message != null && update.message.passport_data != null;
    }


    public boolean commands(String... commands){
        if (update.message == null) return false;
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
            // In accessible message
            if (update.message.date == 0) return false;

            message = update.message;
            user = message.from;
        }

        else if (update.callback_query != null){
            // In accessible message
            if (update.callback_query.message.date == 0) return false;

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
