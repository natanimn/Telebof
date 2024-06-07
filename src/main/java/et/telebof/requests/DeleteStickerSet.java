package et.telebof.requests;

public class DeleteStickerSet extends AbstractBaseRequest<DeleteStickerSet, Boolean> {
    public DeleteStickerSet(String name, RequestSender requestSender) {
        super(requestSender, "deleteStickerSet");
        add("name", name);
    }

    @Override
    public Boolean exec() {
        Object response = requestSender.makeRequest(this);
        return (Boolean) response;
    }
}
