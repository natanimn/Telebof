package et.telebof.types;

import java.io.Serializable;

public class WebAppData extends JsonSerializable implements Serializable {
    private String data, button_text;

    public String getData() {
        return data;
    }

    public String getButtonText() {
        return button_text;
    }
}
