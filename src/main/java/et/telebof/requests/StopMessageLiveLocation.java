package et.telebof.requests;

import et.telebof.types.InlineKeyboardMarkup;
import et.telebof.types.Message;

public class StopMessageLiveLocation extends AbstractBaseRequest<StopMessageLiveLocation, Message> {
    public StopMessageLiveLocation(Object chatId, int messageId, RequestSender requestSender) {
        super(chatId, requestSender, "stopMessageLiveLocation");
        add("message_id", messageId);
    }

    public StopMessageLiveLocation(String inlineMessageId, RequestSender requestSender) {
        super(requestSender, "stopMessageLiveLocation");
        add("inline_message_id", inlineMessageId);
    }

    public StopMessageLiveLocation chatId(Object chatId) {
        return add("chat_id", chatId);
    }

    public StopMessageLiveLocation messageId(int messageId){
        return add("message_id", messageId);
    }

    public StopMessageLiveLocation inlineMessageId(String inlineMessageId){
        return add("inline_message_id", inlineMessageId);
    }

    public StopMessageLiveLocation replyMarkup(InlineKeyboardMarkup replyMarkup) {
        return add("reply_markup", replyMarkup);
    }
}
