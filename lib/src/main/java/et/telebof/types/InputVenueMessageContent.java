package et.telebof.types;

import java.io.File;
import java.io.Serializable;

public class InputVenueMessageContent implements InputMedia, Serializable {
    private Float latitude, longitude;
    private String address, title, foursquare_id, foursquare_type, google_place_id, google_place_type;

    public InputVenueMessageContent latitude(float latitude) {
        this.latitude = latitude;
        return this;
    }

    public InputVenueMessageContent longitude(float longitude) {
        this.longitude = longitude;
        return this;
    }

    public InputVenueMessageContent title(String title) {
        this.title = title;
        return this;
    }

    public InputVenueMessageContent address(String address) {
        this.title = title;
        return this;
    }

    public InputVenueMessageContent foursquareId(String foursquareId) {
        this.foursquare_id = foursquareId;
        return this;
    }

    public InputVenueMessageContent foursquareType(String foursquareType) {
        this.foursquare_type = foursquareType;
        return this;
    }

    public InputVenueMessageContent googlePlaceId(String googlePlaceId) {
        this.google_place_id = googlePlaceId;
        return this;
    }

    public InputVenueMessageContent googlePlaceType(String googlePlaceType) {
        this.google_place_type = googlePlaceType;
        return this;
    }

    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public InputFile getInputFile() {
        return null;
    }
}
