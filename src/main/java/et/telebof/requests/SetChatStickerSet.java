package et.telebof.requests;

public class SetChatStickerSet extends AbstractBaseRequest<SetChatStickerSet, Boolean> {
    public SetChatStickerSet(Object chatId, String stickerSetName, RequestSender requestSender) {
        super(chatId, requestSender, "setChatStickerSet");
        add("sticker_set_name", stickerSetName);
    }

}
