package et.telebof.types;

import et.telebof.BotLog;

import java.io.Serializable;

public class InlineQueryResultCachedVideo extends InlineQueryMediaResult<InlineQueryResultCachedVideo> implements Serializable {

    private String video_file_id, description;

    public InlineQueryResultCachedVideo(String id) {
        super("video", id);
    }

    public InlineQueryResultCachedVideo videoFileId(String videoFileId) {
        this.video_file_id = videoFileId;
        return this;
    }

    public InlineQueryResultCachedVideo description(String description) {
        this.description = description;
        return this;
    }

    @Override
    @Deprecated(forRemoval = true)
    public InlineQueryResultCachedVideo thumbnailUrl(String thumbnailUrl) {
        BotLog.warn("type InlineQueryResultCachedVideo does not support thumbnailUrl option");
        return this;
    }
}
