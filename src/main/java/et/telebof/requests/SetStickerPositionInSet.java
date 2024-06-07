package et.telebof.requests;

public class SetStickerPositionInSet extends AbstractBaseRequest<SetStickerPositionInSet, Boolean> {

    public SetStickerPositionInSet(String sticker, int position, RequestSender requestSender) {
        super(requestSender, "setStickerPositionInSet");
        add("sticker", sticker);
        add("position", position);
    }

    @Override
    public Boolean exec() {
        Object response = requestSender.makeRequest(this);
        return (Boolean) response;
    }
}
