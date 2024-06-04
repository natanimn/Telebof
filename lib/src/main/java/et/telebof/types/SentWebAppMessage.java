package et.telebof.types;

import java.io.Serializable;

public class SentWebAppMessage implements Serializable {
    private String inline_message_id;

    public String getInlineMessageId() {
        return inline_message_id;
    }
}
