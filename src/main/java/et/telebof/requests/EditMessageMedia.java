package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.InlineKeyboardMarkup;
import et.telebof.types.Message;

import java.io.File;

public class EditMessageMedia extends AbstractBaseRequest<EditMessageMedia, Message> {
    public EditMessageMedia(File media, Object chatId, int messageId, RequestSender requestSender) {
        super(chatId, requestSender, "editMessageMedia");
        add("media", media);
        add("message_id", messageId);
    }

    public EditMessageMedia(File media, String inlineMessageId, RequestSender requestSender) {
        super(requestSender, "editMessageMedia");
        add("media", media);
        add("inline_message_id", inlineMessageId);
    }

    public EditMessageMedia replyMarkup(InlineKeyboardMarkup replyMarkup) {
        return add("reply_markup", replyMarkup);
    }

    @Override
    public Message exec() {
        return Util.parse(requestSender.makeRequest(this), Message.class);
    }
}
