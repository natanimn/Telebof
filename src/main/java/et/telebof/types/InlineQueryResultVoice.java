package et.telebof.types;

import java.io.Serializable;

public class InlineQueryResultVoice extends InlineQueryMediaResult<InlineQueryResultVoice> implements Serializable {
    private String voice_url;
    private Integer voice_duration;

    public InlineQueryResultVoice(String id, String voice_url) {
        super("voice", id);
        this.voice_url = voice_url;
    }
    public InlineQueryResultVoice voiceDuration(int voiceDuration) {
        this.voice_duration = voiceDuration;
        return this;
    }

}
