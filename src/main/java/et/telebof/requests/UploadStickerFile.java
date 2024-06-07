package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.File;

public class UploadStickerFile extends AbstractBaseRequest<UploadStickerFile, File> {
    public UploadStickerFile(long userId, java.io.File sticker, String stickerFormat, RequestSender requestSender) {
        super(requestSender, "uploadStickerFile");
        add("user_id", userId);
        add("sticker", sticker);
        add("sticker_format", stickerFormat);
        setContentType(MediaContentType.PHOTO);
    }

    @Override
    public File exec() {
        return Util.parse(requestSender.makeRequest(this), File.class);
    }
}
