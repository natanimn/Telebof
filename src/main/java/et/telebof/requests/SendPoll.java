package et.telebof.requests;

import et.telebof.enums.ParseMode;
import et.telebof.Util;
import et.telebof.enums.PollType;
import et.telebof.types.Markup;
import et.telebof.types.Message;
import et.telebof.types.MessageEntity;

import java.util.List;

/**
 * A class for sending <b>poll</b> to telegram.
 * @author Natanim Negash
 */

public class SendPoll extends AbstractBaseRequest<SendPoll, Message> {

    public SendPoll(Object chatId, String question, String[] options, RequestSender requestSender) {
        super(chatId, requestSender, "sendPoll");
        add("question", question);
        add("options", List.of(options));
    }

    public SendPoll isAnonymous(boolean isAnonymous){
        return add("is_anonymous", isAnonymous);
    }

    public SendPoll type(PollType type){
        return add("type", type.name().toLowerCase());
    }

    public SendPoll allowsMultipleAnswers(boolean allowsMultipleAnswers){
        return add("allows_multiple_answers", allowsMultipleAnswers);
    }

    public SendPoll correctOptionId(int correctOptionId){
        return add("correct_option_id", correctOptionId);
    }

    public SendPoll explanation(String explanation){
        return add("explanation", explanation);
    }

    public SendPoll explanationParseMode(ParseMode explanationParseMode){
        return add("explanation_parse_mode", explanationParseMode.name().toLowerCase());
    }

    public SendPoll explanationEntities(MessageEntity[] explanationEntities){
        return add("explanation_entities", List.of(explanationEntities));
    }

    public SendPoll openPeriod(int openPeriod){
        return add("open_period", openPeriod);
    }

    public SendPoll closeDate(int closeDate){
        return add("close_date", closeDate);
    }

    public SendPoll isClosed(boolean isClosed){
        return add("is_closed", isClosed);
    }

    public SendPoll disableNotification(boolean disableNotification) {
        return add("disable_notification", disableNotification);
    }

    public SendPoll protectContent(boolean protectContent) {
        return add("protect_content", protectContent);
    }

    public SendPoll replyToMessageId(int replyToMessageId) {
        return add("reply_to_message_id", replyToMessageId);
    }

    public SendPoll  allowSendingWithoutReply(boolean allowSendingWithoutReply) {
        return add("allow_sending_without_reply", allowSendingWithoutReply);
    }

    public SendPoll replyMarkup(Markup replyMarkup) {
        return add("reply_markup", replyMarkup);
    }

    @Override
    public Message exec() {
        return Util.parse(requestSender.makeRequest(this), Message.class);
    }
}
