package et.telebof.types;

import et.telebof.requests.MediaContentType;

import java.io.File;
import java.io.Serializable;
import java.util.List;

public class InputSticker implements InputMedia, Serializable {
    private String sticker, format;
    private List<String> emoji_list, keywords;
    private MaskPosition mask_position;
    private boolean isFile;
    transient private InputFile inputFile;

    public InputSticker(File sticker, String format) {
        this.sticker = "attach://"+sticker.getName();
        this.format = format;
        this.inputFile = new InputFile(sticker, MediaContentType.PHOTO);
        isFile = true;
    }

    public InputSticker(String sticker, String format) {
        this.sticker = sticker;
        this.format = format;
        isFile = false;
    }

    public InputSticker emojiList(String[] emojiList) {
        this.emoji_list = List.of(emojiList);
        return this;
    }

    public InputSticker maskPosition(MaskPosition maskPosition) {
        this.mask_position = maskPosition;
        return this;
    }

    public InputSticker keywords(String[] keywords) {
        this.keywords = List.of(keywords);
        return this;
    }

    @Override
    public boolean isFile() {
        return isFile;
    }

    @Override
    public InputFile getInputFile() {
        return null;
    }

}