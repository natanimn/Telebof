package et.telebof.requests;

public class DeleteStickerFromSet extends AbstractBaseRequest<DeleteStickerFromSet, Boolean> {
    public DeleteStickerFromSet(String sticker, RequestSender requestSender){
        super(requestSender, "deleteStickerFromSet");
        add("sticker", sticker);
    }

    @Override
    public Boolean exec() {
        Object response = requestSender.makeRequest(this);
        return (Boolean) response;
    }
}
