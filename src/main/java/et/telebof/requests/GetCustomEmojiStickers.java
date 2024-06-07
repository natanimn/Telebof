package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.Sticker;
import java.util.List;

public class GetCustomEmojiStickers extends AbstractBaseRequest<GetCustomEmojiStickers, List<Sticker>> {
    public GetCustomEmojiStickers(String[] customEmojiIds, RequestSender requestSender) {
        super(requestSender, "getCustomEmojiStickers");
        add("custom_emoji_ids", List.of(customEmojiIds));
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Sticker> exec() {
        return Util.parseList(Util.parse(requestSender.makeRequest(this), List.class), Sticker.class);
    }
}
