package et.telebof.requests;

public class UnpinAllChatMessages extends AbstractBaseRequest<UnpinAllChatMessages, Boolean> {
    public UnpinAllChatMessages(Object chatId, RequestSender requestSender) {
        super(chatId, requestSender, "unpinAllChatMessages");
    }

    @Override
    public Boolean exec() {
        Object response = requestSender.makeRequest(this);
        return (Boolean) response;
    }
}
