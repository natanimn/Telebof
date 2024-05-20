package et.telebof.requests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetStickerEmojiList extends AbstractBaseRequest<SetStickerEmojiList, Boolean> {
    public SetStickerEmojiList(String sticker, String[] emojiList, RequestSender requestSender) {
        super(requestSender, "setStickerEmojiList");
        add("sticker", sticker);
        add("emoji_list", List.of(emojiList));
    }

    @Override
    public Boolean bind() {
        return (Boolean) requestSender.makeRequest(this);
    }
}
