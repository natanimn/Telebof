package et.telebof.requests;

public class DeleteChatPhoto extends AbstractBaseRequest<DeleteChatPhoto, Boolean> {
    public DeleteChatPhoto(Object chatId, RequestSender requestSender) {
        super(chatId, requestSender, "deleteChatPhoto");
    }

}
