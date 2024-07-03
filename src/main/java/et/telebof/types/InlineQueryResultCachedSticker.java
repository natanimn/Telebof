package et.telebof.types;

import java.io.Serializable;

public class InlineQueryResultCachedSticker implements Serializable, InlineQueryResult {
    private String sticker_file_id, type, id;
    private InputTextMessageContent input_message_content;
    private InlineKeyboardMarkup reply_markup;

    public InlineQueryResultCachedSticker(String id) {
        this.type = "sticker";
        this.id = id;
    }

    public InlineQueryResultCachedSticker stickerFileId(String stickerFileId) {
        this.sticker_file_id = stickerFileId;
        return this;
    }

    public InlineQueryResultCachedSticker inputMessageContent(InputTextMessageContent inputTextMessageContent) {
        this.input_message_content = inputTextMessageContent;
        return this;
    }

    public InlineQueryResultCachedSticker replyMarkup(InlineKeyboardMarkup keyboard) {
       this.reply_markup = keyboard;
       return this;
    }

}
