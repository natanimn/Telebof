package et.telebof.types;

import java.io.Serializable;

public class InlineQueryResultCachedSticker implements Serializable, InlineQueryResult {
    private String sticker_file_id, type, id;
    private InputMessageContent input_message_content;
    private InlineKeyboardMarkup reply_markup;

    public InlineQueryResultCachedSticker(String id) {
        this.type = "sticker";
        this.id = id;
    }

    public InlineQueryResultCachedSticker stickerFileId(String stickerFileId) {
        this.sticker_file_id = stickerFileId;
        return this;
    }

    public InlineQueryResultCachedSticker inputMessageContent(InputMessageContent inputMessageContent) {
        this.input_message_content = inputMessageContent;
        return this;
    }

    public InlineQueryResultCachedSticker replyMarkup(InlineKeyboardMarkup keyboard) {
       this.reply_markup = keyboard;
       return this;
    }

}
