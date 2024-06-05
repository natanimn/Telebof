package et.telebof.requests;

import et.telebof.enums.ParseMode;
import et.telebof.Util;
import et.telebof.types.InlineKeyboardMarkup;
import et.telebof.types.Message;
import et.telebof.types.MessageEntity;

import java.util.List;

public class EditMessageCaption extends AbstractBaseRequest<EditMessageCaption, Message> {
    public EditMessageCaption(Object chatId, int messageId, RequestSender requestSender) {
        super(chatId, requestSender, "editMessageCaption");
        add("message_id", messageId);
    }

    public EditMessageCaption(String inlineMessageId, RequestSender requestSender) {
        super(requestSender, "editMessageCaption");
        add("inline_message_id", inlineMessageId);
    }

    public EditMessageCaption chatId(Object chatId) {
        return add("chat_id", chatId);
    }

    public EditMessageCaption messageId(int messageId){
        return add("message_id", messageId);
    }

    public EditMessageCaption inlineMessageId(String inlineMessageId) {
        return add("inline_message_id", inlineMessageId);
    }

    public EditMessageCaption parseMode(ParseMode parseMode) {
        return add("parse_mode",  parseMode!=null?parseMode.name():null);
    }

    public EditMessageCaption entities(MessageEntity[] captionEntities) {
        return add("caption_entities", List.of(captionEntities));
    }

    public EditMessageCaption replyMarkup(InlineKeyboardMarkup replyMarkup) {
        return add("reply_markup", replyMarkup);
    }

    @Override
    public Message bind() {
        return Util.parse(requestSender.makeRequest(this), Message.class);
    }
}
