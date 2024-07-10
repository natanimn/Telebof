package et.telebof.types;

import et.telebof.requests.MediaContentType;

import java.io.File;
import java.io.Serializable;

public class InputMediaPhoto extends InputMediaBuilder<InputMediaPhoto> implements Serializable {
    private Boolean has_spoiler;

    public InputMediaPhoto(String media) {
        super("photo", media);
    }

    public InputMediaPhoto(File media) {
        super("photo", media, MediaContentType.PHOTO);
    }

    public InputMediaPhoto hasSpoiler(boolean hasSpoiler) {
        this.has_spoiler = hasSpoiler;
        return this;
    }
}
