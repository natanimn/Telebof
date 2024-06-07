package et.telebof.types;

import java.io.Serializable;

public class Sticker implements Serializable {
    public String file_id, file_unique_id, type;
    public Integer width, height;
    public Boolean is_animated, is_video;
    public PhotoSize thumbnail;
    public String emoji, setName;
    public File premium_animation;
    public MaskPosition mask_position;
    public String custom_emoji_id;
    public Boolean needs_repainting;
    public Integer file_size;

}
