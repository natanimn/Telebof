package et.telebof.types;

import java.io.Serializable;

public class InlineQueryResultVideo extends InlineQueryMediaResult<InlineQueryResultVideo> implements Serializable {
    private String video_url, description, mime_type;
    private Integer video_width, video_height, video_duration;


    public InlineQueryResultVideo(String id) {
        super("video", id);
    }

    public InlineQueryResultVideo videoUrl(String videoUrl) {
        this.video_url = videoUrl;
        return this;
    }

    public InlineQueryResultVideo videoWidth(int videoWidth) {
        this.video_width = videoWidth;
        return this;
    }

    public InlineQueryResultVideo videoHeight(int videoHeight) {
        this.video_height = videoHeight;
        return this;
    }

    public InlineQueryResultVideo videoDuration(int videoDuration) {
        this.video_duration = videoDuration;
        return this;
    }

    public InlineQueryResultVideo description(String description) {
        this.description = description;
        return this;
    }

    public InlineQueryResultVideo mimeType(String mimeType) {
        this.mime_type = mimeType;
        return this;
    }
}
