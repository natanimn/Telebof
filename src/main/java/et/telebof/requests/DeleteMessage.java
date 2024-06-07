package et.telebof.requests;

public class DeleteMessage extends AbstractBaseRequest<DeleteMessage, Boolean> {
    public DeleteMessage(Object chatId, int messageId, RequestSender requestSender) {
        super(chatId, requestSender, "deleteMessage");
        add("message_id", messageId);
    }

    @Override
    public Boolean exec() {
        Object response = requestSender.makeRequest(this);
        return (Boolean) response;
    }
}
