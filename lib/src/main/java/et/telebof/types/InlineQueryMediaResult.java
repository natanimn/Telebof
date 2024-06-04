package et.telebof.types;

import et.telebof.enums.ParseMode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
class InlineQueryMediaResult<T>  implements Serializable, InlineQueryResult {
    protected String type, id, caption, thumbnail_url, parse_mode, title;
    protected List<MessageEntity> caption_entities;
    protected InputMessageContent input_message_content;
    protected InlineKeyboardMarkup reply_markup;
    T thisT = (T) this;
    public InlineQueryMediaResult(String type, String id) {
        this.type = type;
        this.id = id;
    }

    public T title(String title) {
        this.title = title;
        return thisT;
    }

    public T inputMessageContent(InputMessageContent inputMessageContent) {
        this.input_message_content = inputMessageContent;
        return thisT;
    }

    public T replyMarkup(InlineKeyboardMarkup keyboard) {
        this.reply_markup = keyboard;
        return thisT;
    }

    public T caption(String caption) {
        this.caption = caption;
        return thisT;
    }

    public T thumbnailUrl(String thumbnailUrl) {
        this.thumbnail_url = thumbnailUrl;
        return thisT;
    }

    public T captionEntities(MessageEntity[] captionEntities) {
        this.caption_entities = List.of(captionEntities);
        return thisT;
    }

    public T parseMode(ParseMode parseMode) {
        this.parse_mode = parseMode != null ? parseMode.name().toLowerCase() : null;
        return thisT;
    }

}
