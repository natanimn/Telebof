package et.telebof.types;

import et.telebof.requests.MediaContentType;

import java.io.File;
import java.io.Serializable;

public class InputMediaMediaDocument extends InputMediaBuilder<InputMediaMediaDocument> implements Serializable {
    private String thumbnail;
    private Boolean disable_content_type_detection;

    public InputMediaMediaDocument(String media) {
        super("document", media);
    }

    public InputMediaMediaDocument(File media) {
        super("document", media, MediaContentType.DOCUMENT);
    }

    public InputMediaMediaDocument thumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    public InputMediaMediaDocument disableContentTypeDetection(boolean disableContentTypeDetection) {
        this.disable_content_type_detection = disableContentTypeDetection;
        return this;
    }

}
