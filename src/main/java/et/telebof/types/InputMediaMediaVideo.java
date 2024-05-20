package et.telebof.types;

import et.telebof.requests.MediaContentType;

import java.io.File;
import java.io.Serializable;

public class InputMediaMediaVideo extends InputMediaBuilder<InputMediaMediaVideo> implements  Serializable {
    private String thumbnail;
    private Integer duration, width, height;
    private Boolean has_spoiler, supports_streaming;

    public InputMediaMediaVideo(String media) {
        super("video", media);
    }

    public InputMediaMediaVideo(File media) {
        super("video", media, MediaContentType.VIDEO);
    }

    public InputMediaMediaVideo thumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    public InputMediaMediaVideo width(int width) {
        this.width = width;
        return this;
    }

    public InputMediaMediaVideo height(int height) {
        this.height = height;
        return this;
    }

    public InputMediaMediaVideo duration(int duration) {
        this.duration = duration;
        return this;
    }

    public InputMediaMediaVideo supportsStreaming(boolean supportsStreaming) {
        this.supports_streaming = supportsStreaming;
        return this;
    }

    public InputMediaMediaVideo hasSpoiler(boolean hasSpoiler) {
        this.has_spoiler = hasSpoiler;
        return this;
    }

}
