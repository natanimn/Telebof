package et.telebof.requests;

import et.telebof.types.InlineKeyboardMarkup;
import et.telebof.types.Message;

import java.io.File;

public class EditMessageMedia extends AbstractBaseRequest<EditMessageMedia, Message> {
    public EditMessageMedia(File media, Object chatId, int messageId, RequestSender requestSender) {
        super(chatId, requestSender, "editMessageMedia", Message.class);
        add("media", media);
        add("message_id", messageId);
    }

    public EditMessageMedia(File media, String inlineMessageId, RequestSender requestSender) {
        super(requestSender, "editMessageMedia", Message.class);
        add("media", media);
        add("inline_message_id", inlineMessageId);
    }

    public EditMessageMedia replyMarkup(InlineKeyboardMarkup replyMarkup) {
        return add("reply_markup", replyMarkup);
    }

    public EditMessageMedia businessConnectionId(String business_connection_id){
        return add("business_connection_id", business_connection_id);
    }
}
