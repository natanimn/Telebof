package et.telebof.types;

import et.telebof.requests.MediaContentType;

import java.io.File;
import java.io.Serializable;

public class InputMediaMediaAnimation extends InputMediaBuilder<InputMediaMediaAnimation> implements Serializable {
    private String thumbnail;
    private Integer width, height, duration;
    private Boolean has_spoiler;

    public InputMediaMediaAnimation(String media) {
        super("animation", media);
    }

    public InputMediaMediaAnimation(File media) {
        super("animation", media, MediaContentType.GIF);
    }

    public InputMediaMediaAnimation thumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    public InputMediaMediaAnimation width(int width) {
        this.width = width;
        return this;
    }

    public InputMediaMediaAnimation height(int height){
        this.height = height;
        return this;
    }

    public InputMediaMediaAnimation duration(int duration) {
        this.duration = duration;
        return this;
    }

    public InputMediaMediaAnimation hasSpoiler(boolean hasSpoiler){
        this.has_spoiler = hasSpoiler;
        return this;
    }

}
