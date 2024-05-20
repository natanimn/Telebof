package et.telebof.types;

import java.io.Serializable;

public class InlineQueryResultVenue implements Serializable, InlineQueryResult {
    private String id, type, location, thumbnail_url, title, address, foursquare_id, foursquare_type,
            google_place_id, google_place_type;
    private Integer thumbnail_width, thumbnail_height;
    private Float latitude, longitude, horizontal_accuracy;
    private InputMessageContent input_message_content;
    private InlineKeyboardMarkup reply_markup;

    public InlineQueryResultVenue(String id) {
        this.type = "venue";
        this.id = id;
    }

    public InlineQueryResultVenue latitude(float latitude) {
        this.latitude = latitude;
        return this;
    }

    public InlineQueryResultVenue thumbnailWidth(int thumbnailWidth) {
        this.thumbnail_width = thumbnailWidth;
        return this;
    }

    public InlineQueryResultVenue thumbnailHeight(int thumbnailHeight) {
        this.thumbnail_height = thumbnailHeight;
        return this;
    }

    public InlineQueryResultVenue longitude(float longitude) {
        this.longitude = longitude;
        return this;
    }

    public InlineQueryResultVenue title(String title) {
        this.title = title;
        return this;
    }

    public InlineQueryResultVenue address(String address) {
        this.address = address;
        return this;
    }

    public InlineQueryResultVenue foursquareId(String foursquareId) {
        this.foursquare_id = foursquareId;
        return this;
    }

    public InlineQueryResultVenue foursquareType(String foursquareType) {
        this.foursquare_type = foursquareType;
        return this;
    }

    public InlineQueryResultVenue googlePlaceId(String googlePlaceId) {
        this.google_place_id = googlePlaceId;
        return this;
    }

    public InlineQueryResultVenue googlePlaceType(String googlePlaceType) {
        this.google_place_type = googlePlaceType;
        return this;
    }

    public InlineQueryResultVenue inputMessageContent(InputMessageContent inputMessageContent) {
        this.input_message_content = inputMessageContent;
        return this;
    }

    public InlineQueryResultVenue replyMarkup(InlineKeyboardMarkup keyboard) {
        this.reply_markup = keyboard;
        return this;
    }

    public InlineQueryResultVenue thumbnailUrl(String thumbnailUrl) {
        this.thumbnail_url = thumbnailUrl;
        return this;
    }

}
