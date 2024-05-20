package et.telebof.types;

import java.io.Serializable;

public class ShippingAddress implements Serializable {
    private String country_code, state, city, street_line1, street_line2, post_code;

    public String getCountryCode() {
        return country_code;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getStreetLine1() {
        return street_line1;
    }

    public String getStreetLine2() {
        return street_line2;
    }

    public String getPostCode() {
        return post_code;
    }
}
