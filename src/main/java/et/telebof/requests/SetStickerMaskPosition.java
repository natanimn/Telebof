package et.telebof.requests;

import et.telebof.types.MaskPosition;


public class SetStickerMaskPosition extends AbstractBaseRequest<SetStickerMaskPosition, Boolean> {
    public SetStickerMaskPosition(String sticker, MaskPosition maskPosition, RequestSender requestSender) {
        super(requestSender, "setStickerMaskPosition");
        add("sticker", sticker);
        add("mask_position", maskPosition);
    }

}
