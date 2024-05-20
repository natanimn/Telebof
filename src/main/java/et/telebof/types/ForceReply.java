package et.telebof.types;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ForceReply implements Markup, Serializable {
    private final Map<String, Object> json = new HashMap<>();
    private final boolean force_reply;
    private Boolean selective;
    private String input_field_placeholder;

    public ForceReply() {
        this.force_reply = true;
    }

    public ForceReply inputFieldPlaceholder(String inputFieldPlaceholder){
        this.input_field_placeholder = inputFieldPlaceholder;
        return this;
    }

    public ForceReply selective(boolean selective) {
        this.selective = selective;
        return this;
    }

}
