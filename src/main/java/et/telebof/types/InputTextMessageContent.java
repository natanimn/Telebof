package et.telebof.types;

import et.telebof.enums.ParseMode;

import java.io.Serializable;
import java.util.List;

public class InputTextMessageContent implements Serializable {
    private String message_text, parse_mode;
    List<MessageEntity> entities;
    private Boolean disable_web_page_preview;
    private LinkPreviewOptions link_preview_options;

    public InputTextMessageContent(String text) {
        this.message_text = text;
    }

    public InputTextMessageContent parseMode(ParseMode parseMode) {
        this.parse_mode = parseMode != null? parseMode.name().toLowerCase() : null;
        return this;
    }

    public InputTextMessageContent entities(MessageEntity[] entities) {
        this.entities = List.of(entities);
        return this;
    }

    @Deprecated(since = "v1.5.0")
    public InputTextMessageContent disableWebPagePreview(boolean disableWebPagePreview) {
        this.disable_web_page_preview = disableWebPagePreview;
        return this;
    }

    public InputTextMessageContent linkPreviewOptions(LinkPreviewOptions linkPreviewOptions){
        this.link_preview_options = linkPreviewOptions;
        return this;
    }
}
