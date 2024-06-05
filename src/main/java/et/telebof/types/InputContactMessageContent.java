package et.telebof.types;

import java.util.HashMap;
import java.util.Map;

public class InputContactMessageContent {
    private final Map<String, Object> json = new HashMap<>();
    public InputContactMessageContent phoneNumber(String phoneNumber) {
        json.put("phone_number", phoneNumber);
        return this;
    }

    public InputContactMessageContent firstName(String firstName) {
        json.put("first_name", firstName);
        return this;
    }

    public InputContactMessageContent lastName(String lastName) {
        json.put("last_name", lastName);
        return this;
    }

    public InputContactMessageContent vcard(String vcard) {
        json.put("vcard", vcard);
        return this;
    }

    public Map<String, Object> getJson() {
        return json;
    }
}
