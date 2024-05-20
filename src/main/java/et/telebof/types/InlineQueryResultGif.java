package et.telebof.types;

import java.io.Serializable;

public class InlineQueryResultGif extends InlineQueryMediaResult<InlineQueryResultGif> implements Serializable {
    private String gif_url, thumbnail_mime_type;
    private Integer gif_width;
    public InlineQueryResultGif(String id) {
        super("gif", id);
    }

    public InlineQueryResultGif gifUrl(String gifUrl) {
        this.gif_url = gifUrl;
        return this;
    }

    public InlineQueryResultGif gifWidth(int gifWidth) {
        this.gif_width = gifWidth;
        return this;
    }

    public InlineQueryResultGif thumbnailMimeType(String thumbnailMimeType) {
        this.thumbnail_mime_type = thumbnailMimeType;
        return this;
    }
}
