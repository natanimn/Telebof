package et.telebof.requests;

import et.telebof.enums.StickerType;
import et.telebof.types.InputSticker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CreateNewStickerSet extends AbstractBaseRequest<CreateNewStickerSet, Boolean> {
    public CreateNewStickerSet(long userId, String name, String title, InputSticker[] stickers, String stickerFormat,
                               RequestSender requestSender) {
        super(requestSender, "createNewStickerSet");
        add("user_id", userId);
        add("name", name);
        add("title", title);
        add("stickers", List.of(stickers));
        add("sticker_format", stickerFormat);
    }

    public CreateNewStickerSet stickerType(StickerType stickerType) {
        return add("sticker_type", stickerType.name().toLowerCase());
    }

    public CreateNewStickerSet needsRepainting(boolean needsRepainting) {
        return add("needs_repainting", needsRepainting);
    }

    @Override
    public Boolean exec() {
        Object response = requestSender.makeRequest(this);
        return (Boolean) response;
    }
}
