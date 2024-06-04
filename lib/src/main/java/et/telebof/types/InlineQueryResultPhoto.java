package et.telebof.types;

import java.io.Serializable;

public class InlineQueryResultPhoto extends InlineQueryMediaResult<InlineQueryResultPhoto> implements Serializable {
    private String photo_url, description;
    private Integer photo_width, photo_height;

    public InlineQueryResultPhoto(String id) {
        super("photo", id);
    }

    public InlineQueryResultPhoto photoUrl(String photoUrl) {
        this.photo_url = photoUrl;
        return this;
    }

    public InlineQueryResultPhoto photoWidth(int photoWidth) {
        this.photo_width = photoWidth;
        return this;
    }

    public InlineQueryResultPhoto description(String description) {
        this.description = description;
        return this;
    }

    public InlineQueryResultPhoto photoHeight(int photoHeight) {
        this.photo_height = photoHeight;
        return this;
    }

}
