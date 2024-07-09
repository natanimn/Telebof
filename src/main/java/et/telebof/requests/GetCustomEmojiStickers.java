package et.telebof.requests;

import com.google.gson.reflect.TypeToken;
import et.telebof.Util;
import et.telebof.types.Message;
import et.telebof.types.Sticker;

import java.lang.reflect.Type;
import java.util.List;

public class GetCustomEmojiStickers extends AbstractBaseRequest<GetCustomEmojiStickers, List<Sticker>> {

    private static final Type responseType = TypeToken.getParameterized(List.class, Sticker.class).getType();

    public GetCustomEmojiStickers(String[] customEmojiIds, RequestSender requestSender) {
        super(requestSender, "getCustomEmojiStickers", responseType);
        add("custom_emoji_ids", List.of(customEmojiIds));
    }

}
