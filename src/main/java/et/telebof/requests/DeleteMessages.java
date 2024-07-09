package et.telebof.requests;

public class DeleteMessages extends AbstractBaseRequest<DeleteMessages, Boolean> {

    public DeleteMessages(Object chatId, Integer[] messageIds, RequestSender requestSender) {
        super(chatId, requestSender, "deleteMessages");
        add("message_id", messageIds);
    }

}