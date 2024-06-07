package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.Markup;
import et.telebof.types.Message;

public class SendDice extends AbstractBaseRequest<SendDice, Message> {
    public SendDice(Object chatId, RequestSender requestSender) {
        super(chatId, requestSender, "sendDice");
    }

    public SendDice emoji(String emoji) {
        return add("emoji", emoji);
    }

    public SendDice disableNotification(boolean disableNotification) {
        return add("disable_notification", disableNotification);
    }

    public SendDice protectContent(boolean protectContent) {
        return add("protect_content", protectContent);
    }

    public SendDice replyToMessageId(int replyToMessageId) {
        return add("reply_to_message_id", replyToMessageId);
    }

    public SendDice allowSendingWithoutReply(boolean allowSendingWithoutReply) {
        return add("allow_sending_without_reply", allowSendingWithoutReply);
    }

    public SendDice replyMarkup(Markup replyMarkup) {
        return add("reply_markup", replyMarkup);
    }

    @Override
    public Message exec() {
        return Util.parse(requestSender.makeRequest(this), Message.class);
    }
}
