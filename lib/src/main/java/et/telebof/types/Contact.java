package et.telebof.types;


import java.io.Serializable;

public  class Contact implements Serializable {
    private String phone_number, first_name, last_name, vcard;
    private Long user_id;

    public Long getUserId() {
        return user_id;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public String getVcard() {
        return vcard;
    }
}
