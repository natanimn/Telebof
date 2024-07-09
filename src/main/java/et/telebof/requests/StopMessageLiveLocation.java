package et.telebof.requests;

import et.telebof.types.InlineKeyboardMarkup;
import et.telebof.types.Message;

public class StopMessageLiveLocation extends AbstractBaseRequest<StopMessageLiveLocation, Message> {
    public StopMessageLiveLocation(Object chatId, int messageId, RequestSender requestSender) {
        super(chatId, requestSender, "stopMessageLiveLocation", Message.class);
        add("message_id", messageId);
    }

    public StopMessageLiveLocation(String inlineMessageId, RequestSender requestSender) {
        super(requestSender, "stopMessageLiveLocation", Message.class);
        add("inline_message_id", inlineMessageId);
    }

    public StopMessageLiveLocation replyMarkup(InlineKeyboardMarkup replyMarkup) {
        return add("reply_markup", replyMarkup);
    }
}
