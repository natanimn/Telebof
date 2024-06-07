package et.telebof.types;

import java.io.Serializable;
import java.util.List;

public class StickerSet implements Serializable {
    public String name, title, sticker_type;
    public Boolean is_animated, is_video;
    public List<Sticker> stickers;

}
