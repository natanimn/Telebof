package et.telebof.requests;

public class SetStickerSetTitle extends AbstractBaseRequest<SetStickerSetTitle, Boolean> {

    public SetStickerSetTitle(String sticker, String title, RequestSender requestSender) {
        super(requestSender, "setStickerSetTitle");
        add("sticker", sticker);
        add("title", title);
    }

    @Override
    public Boolean exec() {
        Object response = requestSender.makeRequest(this);
        return (Boolean) response;
    }

}
