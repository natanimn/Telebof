package et.telebof.requests;

import java.io.File;

public class SetStickerSetThumbnail extends AbstractBaseRequest<SetStickerSetThumbnail, Boolean> {

    public SetStickerSetThumbnail(String name, long userId, File thumbnail, RequestSender requestSender) {
        super(requestSender, "setStickerSetThumbnail");
        add("name", name);
        add("user_id", userId);
        add("thumbnail", thumbnail);
        setContentType(MediaContentType.PHOTO);
    }

    public SetStickerSetThumbnail(String name, long userId, String thumbnail, RequestSender requestSender) {
        super(requestSender, "setStickerSetThumbnail");
        add("name", name);
        add("user_id", userId);
        add("thumbnail", thumbnail);
    }

    @Override
    public Boolean exec() {
        Object response = requestSender.makeRequest(this);
        return (Boolean) response;
    }
}
