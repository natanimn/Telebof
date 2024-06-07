package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.StickerSet;

public class GetStickerSet extends AbstractBaseRequest<GetStickerSet, StickerSet> {
    public GetStickerSet(String name, RequestSender requestSender) {
        super(requestSender, "getStickerSet");
        add("name", name);
    }

    @Override
    public StickerSet exec() {
        return Util.parse(requestSender.makeRequest(this), StickerSet.class);
    }
}
