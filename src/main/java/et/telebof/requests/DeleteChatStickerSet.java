package et.telebof.requests;

public class DeleteChatStickerSet extends AbstractBaseRequest<DeleteChatStickerSet, Boolean> {
    public DeleteChatStickerSet(Object chatId, RequestSender requestSender) {
        super(chatId, requestSender, "deleteChatStickerSet");
    }

}
