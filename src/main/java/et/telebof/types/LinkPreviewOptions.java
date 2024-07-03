package et.telebof.types;

import java.io.Serializable;

public class LinkPreviewOptions implements Serializable {
    public Boolean is_disabled, prefer_small_media, prefer_large_media, show_above_text;
    public String url;

    public LinkPreviewOptions isDisabled(boolean is_disabled){
        this.is_disabled = is_disabled;
        return this;
    }

    public LinkPreviewOptions preferLargeMedia(boolean prefer_large_media){
        this.prefer_large_media = prefer_large_media;
        return this;
    }

    public LinkPreviewOptions preferSmallMedia(boolean prefer_small_media){
        this.prefer_small_media = prefer_small_media;
        return this;
    }

    public LinkPreviewOptions showAboveText(boolean show_above_text){
        this.show_above_text = show_above_text;
        return this;
    }

    public LinkPreviewOptions url(String url){
        this.url = url;
        return this;
    }

}
