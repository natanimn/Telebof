package et.telebof.requests;

public class DeleteChatPhoto extends AbstractBaseRequest<DeleteChatPhoto, Boolean> {
    public DeleteChatPhoto(Object chatId, RequestSender requestSender) {
        super(chatId, requestSender, "deleteChatPhoto");
    }

    @Override
    public Boolean exec() {
        Object response = requestSender.makeRequest(this);
        return (Boolean) response;
    }
}
