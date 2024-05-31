package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.InlineKeyboardMarkup;
import et.telebof.types.Message;

public class EditMessageReplyMarkup extends AbstractBaseRequest<EditMessageReplyMarkup, Message> {
    public EditMessageReplyMarkup(Object chatId, int messageId, RequestSender requestSender) {
        super(chatId, requestSender, "editMessageReplyMarkup");
        add("message_id", messageId);
    }

    public EditMessageReplyMarkup(String inlineMessageId, RequestSender requestSender) {
        super(requestSender, "editMessageReplyMarkup");
        add("inline_message_id", inlineMessageId);
    }

    public EditMessageReplyMarkup replyMarkup(InlineKeyboardMarkup replyMarkup) {
        return add("reply_markup", replyMarkup);
    }

    @Override
    public Message bind() {
        return Util.parse(requestSender.makeRequest(this), Message.class);
    }
}
