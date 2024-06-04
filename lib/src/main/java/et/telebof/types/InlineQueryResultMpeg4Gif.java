package et.telebof.types;

import java.io.Serializable;

public class InlineQueryResultMpeg4Gif extends InlineQueryMediaResult<InlineQueryResultMpeg4Gif> implements Serializable {
    private String mpeg4_url, thumbnail_mime_type;
    private Integer mpeg4_width, mpeg4_height, mpeg4_duration;

    public InlineQueryResultMpeg4Gif(String id) {
        super("mpeg4_url", id);
    }

    public InlineQueryResultMpeg4Gif mpeg4Url(String mpeg4Url) {
        this.mpeg4_url = mpeg4Url;
        return this;
    }

    public InlineQueryResultMpeg4Gif mpeg4Width(int mpeg4Width) {
        this.mpeg4_width = mpeg4Width;
        return this;
    }

    public InlineQueryResultMpeg4Gif mpeg4Height(int mpeg4Height) {
        this.mpeg4_height = mpeg4Height;
        return this;
    }

    public InlineQueryResultMpeg4Gif mpeg4Duration(int mpeg4Duration) {
        this.mpeg4_duration = mpeg4Duration;
        return this;
    }

    public InlineQueryResultMpeg4Gif thumbnailMimeType(String thumbnailMimeType) {
        this.thumbnail_mime_type = thumbnailMimeType;
        return this;
    }

}
