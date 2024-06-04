package et.telebof.types;

import et.telebof.BotLog;
import et.telebof.errors.TelegramError;

import java.io.Serializable;

public class InlineQueryResultCachedMpeg4Gif extends InlineQueryMediaResult<InlineQueryResultCachedMpeg4Gif> implements Serializable {
    private String mpeg4_file_id;
    public InlineQueryResultCachedMpeg4Gif(String id) {
        super("mpeg4", id);
    }

    public InlineQueryResultCachedMpeg4Gif mpeg4FileId(String mpeg4FileId) {
        this.mpeg4_file_id = mpeg4FileId;
        return this;
    }

    @Deprecated(forRemoval = true)
    public InlineQueryResultCachedMpeg4Gif thumbnailUrl(String thumbnailUrl) {
        BotLog.warn("type InlineQueryResultCachedMpeg4Gif does not support thumbnailUrl option");
        return this;
    }
}
