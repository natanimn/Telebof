package et.telebof.requests;
import et.telebof.enums.ParseMode;
import et.telebof.types.Markup;

/**
 * @author Natanim Negash
 * @version 1.1.2 1.1.0

 */
abstract public class DefaultParameters<T, R> extends AbstractBaseRequest<T, R> {

    public DefaultParameters(Object chatId, RequestSender requestSender, String methodName) {
        super(chatId, requestSender, methodName);
        add("allow_sending_without_reply", true);
    }

    public T messageThreadId(int messageThreadId) {
        return add("message_thread_id", messageThreadId);
    }

    public T parseMode(ParseMode parseMode) {
        return add("parse_mode",  parseMode != null ? parseMode.name() : null);
    }

    public T disableWebPagePreview(boolean disableWebPagePreview) {
        return add("disable_web_page_preview", disableWebPagePreview);
    }

    public T disableNotification(boolean disableNotification) {
        return add("disable_notification", disableNotification);
    }

    public T protectContent(boolean protectContent) {
        return add("protect_content", protectContent);
    }

    public T replyToMessageId(int replyToMessageId) {
        return add("reply_to_message_id", replyToMessageId);
    }

    public T allowSendingWithoutReply(boolean allowSendingWithoutReply) {
        return add("allow_sending_without_reply", allowSendingWithoutReply);
    }

    public T replyMarkup(Markup replyMarkup) {
        return add("reply_markup", replyMarkup);
    }

}
