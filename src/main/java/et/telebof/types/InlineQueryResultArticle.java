package et.telebof.types;

import java.io.Serializable;

public class InlineQueryResultArticle implements Serializable, InlineQueryResult {
    private String id, type, url, description, thumbnail_url, title;
    private Integer thumbnail_width, thumbnail_height;
    private InputMessageContent input_message_content;
    private InlineKeyboardMarkup reply_markup;
    private Boolean hide_url;

    public InlineQueryResultArticle(String id) {
        this.type = "article";
        this.id = id;
    }

    public InlineQueryResultArticle title(String title) {
        this.title = title;
        return this;
    }

    public InlineQueryResultArticle inputMessageContent(InputMessageContent inputMessageContent) {
        this.input_message_content = inputMessageContent;
        return this;
    }

    public InlineQueryResultArticle replyMarkup(InlineKeyboardMarkup keyboard) {
        this.reply_markup = keyboard;
        return this;
    }

    public InlineQueryResultArticle url(String url) {
        this.url = url;
        return this;
    }

    public InlineQueryResultArticle hideUrl(boolean hideUrl) {
        this.hide_url = hideUrl;
        return this;
    }

    public InlineQueryResultArticle description(String description) {
        this.description = description;
        return this;
    }

    public InlineQueryResultArticle thumbnailUrl(String thumbnailUrl) {
        this.thumbnail_url = thumbnailUrl;
        return this;
    }

    public InlineQueryResultArticle thumbnailWidth(int thumbnailWidth) {
        this.thumbnail_width = thumbnailWidth;
        return this;
    }

    public InlineQueryResultArticle thumbnailHeight(int thumbnailHeight) {
        this.thumbnail_height = thumbnailHeight;
        return this;
    }


}
