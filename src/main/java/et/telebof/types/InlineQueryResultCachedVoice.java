package et.telebof.types;

import et.telebof.BotLog;

import java.io.Serializable;

public class InlineQueryResultCachedVoice extends InlineQueryMediaResult<InlineQueryResultCachedVoice> implements Serializable {
    private String voice_file_id, description;

    public InlineQueryResultCachedVoice(String id) {
        super("voice", id);
    }

    public InlineQueryResultCachedVoice voiceFileId(String voiceFileId) {
        this.voice_file_id = voiceFileId;
        return this;
    }

    public InlineQueryResultCachedVoice description(String description) {
        this.description = description;
        return this;
    }

    @Override
    @Deprecated(forRemoval = true)
    public InlineQueryResultCachedVoice thumbnailUrl(String thumbnailUrl) {
        BotLog.warn("type InlineQueryResultCachedVoice does not support thumbnailUrl option");
        return this;
    }
}
