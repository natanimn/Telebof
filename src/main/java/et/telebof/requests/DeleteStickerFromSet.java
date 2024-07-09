package et.telebof.requests;

public class DeleteStickerFromSet extends AbstractBaseRequest<DeleteStickerFromSet, Boolean> {
    public DeleteStickerFromSet(String sticker, RequestSender requestSender){
        super(requestSender, "deleteStickerFromSet");
        add("sticker", sticker);
    }

}
