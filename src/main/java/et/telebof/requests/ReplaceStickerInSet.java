package et.telebof.requests;

import java.io.File;

public class ReplaceStickerInSet extends AbstractBaseRequest<ReplaceStickerInSet, Boolean>{

    public ReplaceStickerInSet(long user_id, String name, String old_sticker, File sticker, RequestSender requestSender){
        super(requestSender, "replaceStickerInSet");
        add("user_id", user_id);
        add("name", name);
        add("old_sticker", old_sticker);
        add("sticker", sticker);
        this.setContentType(MediaContentType.PHOTO);
    }

    @Override
    public Boolean exec() {
        return (Boolean) requestSender.makeRequest(this);
    }
}
