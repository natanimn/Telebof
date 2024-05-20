package et.telebof.types;

import et.telebof.enums.ParseMode;

import java.io.Serializable;
import java.util.List;

public class InputMessageContent implements Serializable {
    private String message_text, parse_mode;
    List<MessageEntity> entities;
    private Boolean disable_web_page_preview;

    public InputMessageContent(){}

    public InputMessageContent(String text) {
        this.message_text = text;
    }

    public InputMessageContent messageText(String text) {
        this.message_text = text;
        return this;
    }

    public InputMessageContent parseMode(ParseMode parseMode) {
        this.parse_mode = parseMode != null? parseMode.name().toLowerCase() : null;
        return this;
    }

    public InputMessageContent entities(MessageEntity[] entities) {
        this.entities = List.of(entities);
        return this;
    }

    public InputMessageContent disableWebPagePreview(boolean disableWebPagePreview) {
        this.disable_web_page_preview = disableWebPagePreview;
        return this;
    }

}
