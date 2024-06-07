package et.telebof.requests;

public class DeleteChatStickerSet extends AbstractBaseRequest<DeleteChatStickerSet, Boolean> {
    public DeleteChatStickerSet(Object chatId, RequestSender requestSender) {
        super(chatId, requestSender, "deleteChatStickerSet");
    }

    @Override
    public Boolean exec() {
        Object response = requestSender.makeRequest(this);
        return (Boolean) response;
    }
}
