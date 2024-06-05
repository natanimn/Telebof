package et.telebof.types;

import java.io.Serializable;

public class InlineQueryResultVoice extends InlineQueryMediaResult<InlineQueryResultVoice> implements Serializable {
    private String voice_url;
    private Integer voice_duration;
    public InlineQueryResultVoice(String id) {
        super("voice", id);
    }

    public InlineQueryResultVoice voiceUrl(String voiceUrl) {
        this.voice_url = voiceUrl;
        return this;
    }

    public InlineQueryResultVoice voiceDuration(int voiceDuration) {
        this.voice_duration = voiceDuration;
        return this;
    }

}
