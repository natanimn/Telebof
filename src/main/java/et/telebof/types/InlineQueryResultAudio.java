package et.telebof.types;

import java.io.Serializable;

public class InlineQueryResultAudio implements Serializable, InlineQueryResult {
    private String id, type, audio_url, performer;
    private Integer audio_duration;
    public InlineQueryResultAudio(String id) {
        this.type = "audio";
        this.id = id;
    }

    public InlineQueryResultAudio audioUrl(String audioUrl) {
        this.audio_url = audioUrl;
        return this;
    }

    public InlineQueryResultAudio performer(String performer) {
        this.performer = performer;
        return this;
    }

    public InlineQueryResultAudio audioDuration(int audioDuration) {
        this.audio_duration = audioDuration;
        return this;
    }

}
