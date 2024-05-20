package et.telebof.types;

import et.telebof.BotLog;

import java.io.Serializable;

public class InlineQueryResultCachedPhoto extends InlineQueryMediaResult<InlineQueryResultCachedPhoto> implements Serializable {
    private String photo_file_id, description;
    public InlineQueryResultCachedPhoto(String id) {
        super("photo", id);
    }

    public InlineQueryResultCachedPhoto photoFileId(String photoFileId) {
        this.photo_file_id = photoFileId;
        return this;
    }

    public InlineQueryResultCachedPhoto description(String description) {
        this.description = description;
        return this;
    }

    @Deprecated(forRemoval = true)
    public InlineQueryResultCachedPhoto thumbnailUrl(String thumbnailUrl) {
        BotLog.warn("InlineQueryResultCachedPhoto does not support thumbnailUrl option");
        return this;
    }
}
