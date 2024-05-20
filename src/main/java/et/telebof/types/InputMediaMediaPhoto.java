package et.telebof.types;

import et.telebof.requests.MediaContentType;

import java.io.File;
import java.io.Serializable;

public class InputMediaMediaPhoto extends InputMediaBuilder<InputMediaMediaPhoto> implements Serializable {
    private Boolean has_spoiler;

    public InputMediaMediaPhoto(String media) {
        super("photo", media);
    }

    public InputMediaMediaPhoto(File media) {
        super("photo", media, MediaContentType.PHOTO);
    }

    public InputMediaMediaPhoto hasSpoiler(boolean hasSpoiler) {
        this.has_spoiler = hasSpoiler;
        return this;
    }
}
