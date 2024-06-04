package et.telebof.requests;

public class DeleteChatPhoto extends AbstractBaseRequest<DeleteChatPhoto, Boolean> {
    public DeleteChatPhoto(Object chatId, RequestSender requestSender) {
        super(chatId, requestSender, "deleteChatPhoto");
    }

    @Override
    public Boolean bind() {
        return (Boolean) requestSender.makeRequest(this);
    }
}
