package et.telebof.types;

import et.telebof.requests.MediaContentType;

import java.io.File;
import java.io.Serializable;

public class InputMediaMediaAudio extends InputMediaBuilder<InputMediaMediaAudio> implements Serializable {
    private String thumbnail, performer, title;
    private Integer duration;
    private Boolean has_spoiler;

    public InputMediaMediaAudio(String media) {
        super("audio", media);
    }

    public InputMediaMediaAudio(File media) {
        super("audio", media, MediaContentType.AUDIO);
    }

    public InputMediaMediaAudio thumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    public InputMediaMediaAudio performer(String performer) {
        this.performer = performer;
        return this;
    }

    public InputMediaMediaAudio title(String title) {
        this.title = title;
        return this;
    }

    public InputMediaMediaAudio duration(int duration) {
        this.duration = duration;
        return this;
    }

    public InputMediaMediaAudio hasSpoiler(boolean hasSpoiler) {
        this.has_spoiler = hasSpoiler;
        return this;
    }
}
