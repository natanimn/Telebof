package et.telebof.types;

import et.telebof.BotLog;

import java.io.Serializable;

public class InlineQueryResultCachedAudio extends InlineQueryMediaResult<InlineQueryResultCachedAudio> implements Serializable {
    private String audio_file_id, description;
    public InlineQueryResultCachedAudio(String id, String audioFileId) {
        super("audio", id);
        this.audio_file_id = audioFileId;
    }

    public InlineQueryResultCachedAudio description(String description) {
        this.description = description;
        return this;
    }

}
