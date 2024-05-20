package et.telebof.requests;

import et.telebof.types.InlineKeyboardMarkup;
import et.telebof.types.Poll;

public class StopPoll extends AbstractBaseRequest<StopPoll, Poll> {
    public StopPoll(Object chatId, int messageId, RequestSender requestSender) {
        super(chatId, requestSender, "stopPoll");
        add("message_id", messageId);
    }

    public StopPoll replyMarkup(InlineKeyboardMarkup replyMarkup) {
        return add("reply_markup", replyMarkup);
    }
}
