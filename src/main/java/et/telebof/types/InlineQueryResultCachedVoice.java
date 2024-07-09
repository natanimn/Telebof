package et.telebof.types;

import et.telebof.BotLog;

import java.io.Serializable;

public class InlineQueryResultCachedVoice extends InlineQueryMediaResult<InlineQueryResultCachedVoice> implements Serializable {
    private String voice_file_id, description;

    public InlineQueryResultCachedVoice(String id, String voiceFileId) {
        super("voice", id);
        this.voice_file_id = voiceFileId;
    }

    public InlineQueryResultCachedVoice description(String description) {
        this.description = description;
        return this;
    }
}
