package et.telebof.types;

import java.io.Serializable;
import java.util.List;

public class StickerSet implements Serializable {
    private String name, title, sticker_type;
    private Boolean is_animated, is_video;
    private List<Sticker> stickers;
    private PhotoSize thumbnail;

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getStickerType() {
        return sticker_type;
    }

    public Boolean getIsAnimated() {
        return is_animated;
    }

    public Boolean getIsVideo() {
        return is_video;
    }

    public List<Sticker> getStickers() {
        return stickers;
    }

    public PhotoSize getThumbnail() {
        return thumbnail;
    }
}
