package et.telebof.types;

import et.telebof.BotLog;

import java.io.Serializable;

public class InlineQueryResultCachedGif extends InlineQueryMediaResult<InlineQueryResultCachedGif> implements Serializable {
    private String gif_file_id;
    public InlineQueryResultCachedGif(String id) {
        super("gif", id);
    }

    public InlineQueryResultCachedGif gifFileId(String gifFileId) {
        this.gif_file_id = gifFileId;
        return this;
    }

    @Deprecated(forRemoval = true)
    public InlineQueryResultCachedGif thumbnailUrl(String thumbnailUrl) {
        BotLog.warn("type InlineQueryResultCachedGif does not support thumbnailUrl option");
        return this;
    }

}
