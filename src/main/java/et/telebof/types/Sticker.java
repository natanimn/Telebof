package et.telebof.types;

import java.io.Serializable;

public class Sticker implements Serializable {
    private String file_id, file_unique_id, type;
    private Integer width, height;
    private Boolean is_animated, is_video;
    private PhotoSize thumbnail;
    private String emoji, setName;
    private File premium_animation;
    private MaskPosition mask_position;
    private String custom_emoji_id;
    private Boolean needs_repainting;
    private Integer file_size;

    public String getFileId() {
        return file_id;
    }

    public String getFileUniqueId() {
        return file_unique_id;
    }

    public String getType() {
        return type;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public Boolean getIsAnimated() {
        return is_animated;
    }

    public Boolean getIsVideo() {
        return is_video;
    }

    public PhotoSize getThumbnail() {
        return thumbnail;
    }

    public String getEmoji() {
        return emoji;
    }

    public String getSetName() {
        return setName;
    }

    public File getPremiumAnimation() {
        return premium_animation;
    }

    public MaskPosition getMaskPosition() {
        return mask_position;
    }

    public String getCustomEmojiId() {
        return custom_emoji_id;
    }

    public Boolean getNeedsRepainting() {
        return needs_repainting;
    }

    public Integer getFileSize() {
        return file_size;
    }
}
