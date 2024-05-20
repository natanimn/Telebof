package et.telebof.types;

import java.io.Serializable;

public class InlineQueryResultContact implements Serializable, InlineQueryResult {
    private String type, id, phone_number, first_name, last_name, vcard, thumbnail_url;
    private Integer thumbnail_width, thumbnail_height;
    private InlineKeyboardMarkup reply_markup;
    private InputMessageContent input_message_content;
    public InlineQueryResultContact(String id) {
        this.type = "contact";
        this.id = id;
    }

    public InlineQueryResultContact phoneNumber(String phoneNumber) {
        this.phone_number = phoneNumber;
        return this;
    }

    public InlineQueryResultContact firstName(String firstName) {
        this.first_name = firstName;
        return this;
    }

    public InlineQueryResultContact lastName(String lastName) {
        this.last_name = lastName;
        return this;
    }

    public InlineQueryResultContact vcard(String vcard) {
        this.vcard = vcard;
        return this;
    }

    public InlineQueryResultContact inputMessageContent(InputMessageContent inputMessageContent) {
        this.input_message_content = inputMessageContent;
        return this;
    }

    public InlineQueryResultContact replyMarkup(InlineKeyboardMarkup keyboard) {
        this.reply_markup = keyboard;
        return this;
    }

    public InlineQueryResultContact thumbnailUrl(String thumbnailUrl) {
        this.thumbnail_url = thumbnailUrl;
        return this;
    }

    public InlineQueryResultContact thumbnailWidth(int thumbnailWidth) {
        this.thumbnail_width = thumbnailWidth;
        return this;
    }

    public InlineQueryResultContact thumbnailHeight(int thumbnailHeight) {
        this.thumbnail_height = thumbnailHeight;
        return this;
    }

}
