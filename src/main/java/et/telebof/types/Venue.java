package et.telebof.types;

import java.io.Serializable;

public class Venue implements Serializable {
    public String title, address, foursquare_id, foursquare_type, google_place_id, google_place_type;
    public Location location;

}
