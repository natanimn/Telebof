package et.telebof.types;

import java.io.Serializable;

public class Venue implements Serializable {
    private String title, address, foursquare_id, foursquare_type, google_place_id, google_place_type;
    private Location location;

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public String getFoursquareId() {
        return foursquare_id;
    }

    public String getFoursquareType() {
        return foursquare_type;
    }

    public String getGooglePlaceId() {
        return google_place_id;
    }

    public String getGooglePlaceType() {
        return google_place_type;
    }

    public Location getLocation() {
        return location;
    }
}
