package et.telebof.types;

import et.telebof.BotLog;

import java.io.Serializable;

public class InlineQueryResultCachedVideo extends InlineQueryMediaResult<InlineQueryResultCachedVideo> implements Serializable {

    private String video_file_id, description;
    private Boolean show_caption_above_media;

    public InlineQueryResultCachedVideo(String id, String video_file_id) {
        super("video", id);
        this.video_file_id = video_file_id;
    }

    public InlineQueryResultCachedVideo description(String description) {
        this.description = description;
        return this;
    }

    public InlineQueryResultCachedVideo showCaptionAboveMedia(boolean show_caption_above_media){
        this.show_caption_above_media = show_caption_above_media;
        return this;
    }
}
