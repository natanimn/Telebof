package et.telebof.types;

import java.io.Serializable;

public class InlineQueryResultLocation implements Serializable, InlineQueryResult {
    private String id, type, location, thumbnail_url;
    private Integer live_period, heading, proximity_alert_radius, thumbnail_width, thumbnail_height;
    private Float latitude, longitude, horizontal_accuracy;
    private InputMessageContent input_message_content;
    private InlineKeyboardMarkup reply_markup;

    public InlineQueryResultLocation(String id) {
        this.type = "location";
        this.id = id;
    }

    public InlineQueryResultLocation latitude(float latitude) {
        this.latitude = latitude;
        return this;
    }

    public InlineQueryResultLocation longitude(float longitude) {
        this.longitude = longitude;
        return this;
    }

    public InlineQueryResultLocation horizontalAccuracy(float horizontalAccuracy) {
        this.horizontal_accuracy = horizontalAccuracy;
        return this;
    }

    public InlineQueryResultLocation livePeriod(int livePeriod) {
        this.live_period = livePeriod;
        return this;
    }

    public InlineQueryResultLocation heading(int heading) {
        this.heading = heading;
        return this;
    }

    public InlineQueryResultLocation proximityAlertRadius(int proximityAlertRadius) {
        this.proximity_alert_radius = proximityAlertRadius;
        return this;
    }

    public InlineQueryResultLocation inputMessageContent(InputMessageContent inputMessageContent) {
        this.input_message_content = inputMessageContent;
        return this;
    }

    public InlineQueryResultLocation replyMarkup(InlineKeyboardMarkup keyboard) {
        this.reply_markup = keyboard;
        return this;
    }

    public InlineQueryResultLocation thumbnailUrl(String thumbnailUrl) {
        this.thumbnail_url = thumbnailUrl;
        return this;
    }

    public InlineQueryResultLocation thumbnailWidth(int thumbnailWidth) {
        this.thumbnail_width = thumbnailWidth;
        return this;
    }

    public InlineQueryResultLocation thumbnailHeight(int thumbnailHeight) {
        this.thumbnail_height = thumbnail_height;
        return this;
    }

}
