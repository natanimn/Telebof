package et.telebof.types;

import et.telebof.BotLog;

import java.io.Serializable;

public class InlineQueryResultCachedAudio extends InlineQueryMediaResult<InlineQueryResultCachedAudio> implements Serializable {
    private String audio_file_id, description;
    public InlineQueryResultCachedAudio(String id) {
        super("audio", id);
    }

    public InlineQueryResultCachedAudio audioFileId(String audioFileId) {
        this.audio_file_id = audioFileId;
        return this;
    }

    public InlineQueryResultCachedAudio description(String description) {
        this.description = description;
        return this;
    }

    @Override
    @Deprecated(forRemoval = true)
    public InlineQueryResultCachedAudio thumbnailUrl(String thumbnailUrl) {
        BotLog.warn("type InlineQueryResultCachedAudio does not support thumbnailUrl option");
        return this;
    }
}
