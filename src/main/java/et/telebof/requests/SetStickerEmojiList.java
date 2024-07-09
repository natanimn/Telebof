package et.telebof.requests;

import java.util.List;

public class SetStickerEmojiList extends AbstractBaseRequest<SetStickerEmojiList, Boolean> {
    public SetStickerEmojiList(String sticker, String[] emojiList, RequestSender requestSender) {
        super(requestSender, "setStickerEmojiList");
        add("sticker", sticker);
        add("emoji_list", List.of(emojiList));
    }

}
