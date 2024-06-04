package et.telebof.requests;

import et.telebof.types.Markup;
import et.telebof.types.Message;

public class SendContact extends AbstractBaseRequest<SendContact, Message> {

    public SendContact(Object chatId, String phoneNumber, String firstName, RequestSender requestSender) {
        super(chatId, requestSender, "sendContact");
        add("phone_number", phoneNumber);
        add("first_name", firstName);
    }

    public SendContact lastName(String lastName) {
        return add("last_name", lastName);
    }

    public SendContact vcard(String vcard) {
        return add("vcard", vcard);
    }

    public SendContact disableNotification(boolean disableNotification) {
        return add("disable_notification", disableNotification);
    }

    public SendContact protectContent(boolean protectContent) {
        return add("protect_content", protectContent);
    }

    public SendContact replyToMessageId(int replyToMessageId) {
        return add("reply_to_message_id", replyToMessageId);
    }

    public SendContact allowSendingWithoutReply(boolean allowSendingWithoutReply) {
        return add("allow_sending_without_reply", allowSendingWithoutReply);
    }

    public SendContact replyMarkup(Markup replyMarkup) {
        return add("reply_markup", replyMarkup);
    }

}
