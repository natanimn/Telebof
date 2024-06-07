package et.telebof.requests;

public class UnpinChatMessage extends AbstractBaseRequest<UnpinChatMessage, Boolean> {
    public UnpinChatMessage(Object chatId, RequestSender requestSender) {
        super(chatId, requestSender, "unpinChatMessage");
    }

    public UnpinChatMessage messageId(int messageId) {
        return add("message_id", messageId);
    }

    @Override
    public Boolean exec() {
        Object response = requestSender.makeRequest(this);
        return (Boolean) response;
    }
}
