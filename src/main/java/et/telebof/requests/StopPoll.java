package et.telebof.requests;

import et.telebof.types.InlineKeyboardMarkup;
import et.telebof.types.Poll;

public class StopPoll extends AbstractBaseRequest<StopPoll, Poll> {
    public StopPoll(Object chatId, int messageId, RequestSender requestSender) {
        super(chatId, requestSender, "stopPoll", Poll.class);
        add("message_id", messageId);
    }

    public StopPoll replyMarkup(InlineKeyboardMarkup replyMarkup) {
        return add("reply_markup", replyMarkup);
    }

    public StopPoll businessConnectionId(String business_connection_id){
        return add("business_connection_id", business_connection_id);
    }
}
