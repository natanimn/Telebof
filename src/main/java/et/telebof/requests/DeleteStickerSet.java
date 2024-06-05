package et.telebof.requests;

public class DeleteStickerSet extends AbstractBaseRequest<DeleteStickerSet, Boolean> {
    public DeleteStickerSet(String name, RequestSender requestSender) {
        super(requestSender, "deleteStickerSet");
        add("name", name);
    }

    @Override
    public Boolean bind() {
        return (Boolean) requestSender.makeRequest(this);
    }
}
