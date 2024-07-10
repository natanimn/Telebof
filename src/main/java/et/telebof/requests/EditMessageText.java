package et.telebof.requests;

import et.telebof.enums.ParseMode;
import et.telebof.types.InlineKeyboardMarkup;
import et.telebof.types.LinkPreviewOptions;
import et.telebof.types.Message;
import et.telebof.types.MessageEntity;

import java.util.List;

public class EditMessageText extends AbstractBaseRequest<EditMessageText, Message> {
    public EditMessageText(String text, Object chatId, int messageId, RequestSender requestSender) {
        super(chatId, requestSender, "editMessageText", Message.class);
        add("text", text);
        add("message_id", messageId);
    }

    public EditMessageText(String text, String inlineMessageId, RequestSender requestSender) {
        super(requestSender, "editMessageText", Message.class);
        add("text", text);
        add("inline_message_id", inlineMessageId);
    }

    public EditMessageText parseMode(ParseMode parseM) {
        return add("parse_mode",  parseM!=null?parseM.name():null);
    }

    public EditMessageText entities(MessageEntity[] entities) {
        return add("entities", List.of(entities));
    }

    @Deprecated(since = "v1.5.0")
    public EditMessageText disableWebPagePreview(boolean disableWebPagePreview) {
        return add("disable_web_page_preview", disableWebPagePreview);
    }

    public EditMessageText linkPreviewOption(LinkPreviewOptions linkPreviewOptions) {
        return add("disable_web_page_preview", linkPreviewOptions);
    }

    public EditMessageText replyMarkup(InlineKeyboardMarkup replyMarkup) {
        return add("reply_markup", replyMarkup);
    }

    public EditMessageText businessConnectionId(String business_connection_id){
        return add("business_connection_id", business_connection_id);
    }
}
