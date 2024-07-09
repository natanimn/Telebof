package et.telebof.requests;

public class UnpinChatMessage extends AbstractBaseRequest<UnpinChatMessage, Boolean> {
    public UnpinChatMessage(Object chatId, RequestSender requestSender) {
        super(chatId, requestSender, "unpinChatMessage");
    }

    public UnpinChatMessage messageId(int messageId) {
        return add("message_id", messageId);
    }

}
