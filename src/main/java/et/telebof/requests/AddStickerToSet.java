package et.telebof.requests;

import java.io.File;

public class AddStickerToSet extends AbstractBaseRequest<AddStickerToSet, Boolean> {
    public AddStickerToSet(long userId, String name, File sticker, RequestSender requestSender){
        super(requestSender, "addStickerToSet");
        add("user_id", userId);
        add("name", name);
        add("sticker", sticker);
        this.setContentType(MediaContentType.PHOTO);
    }
}
