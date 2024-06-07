package et.telebof.types;

import java.io.Serializable;
import java.util.Map;

public class InputContactMessageContent implements Serializable {
    private String phone_number, first_name, last_name, vcard;

    public InputContactMessageContent phoneNumber(String phoneNumber) {
        this.phone_number = phoneNumber;
        return this;
    }

    public InputContactMessageContent firstName(String firstName) {
        this.first_name = firstName;
        return this;
    }

    public InputContactMessageContent lastName(String lastName) {
        this.last_name = lastName;
        return this;
    }

    public InputContactMessageContent vcard(String vcard) {
        this.vcard = vcard;
        return this;
    }

}
