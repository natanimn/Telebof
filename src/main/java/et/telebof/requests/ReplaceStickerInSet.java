package et.telebof.requests;

import et.telebof.types.InputSticker;



public class ReplaceStickerInSet extends AbstractBaseRequest<ReplaceStickerInSet, Boolean>{

    public ReplaceStickerInSet(long user_id, String name, String old_sticker, InputSticker sticker, RequestSender requestSender){
        super(requestSender, "replaceStickerInSet");
        add("user_id", user_id);
        add("name", name);
        add("old_sticker", old_sticker);
        add("sticker", sticker);
    }

}
