package et.telebof.requests;

public class DeleteForumTopic extends AbstractBaseRequest<DeleteForumTopic, Boolean> {
    public DeleteForumTopic(Object chatId, int messageThreadId, RequestSender requestSender) {
        super(chatId, requestSender, "deleteForumTopic");
        add("message_thread_id", messageThreadId);
    }
}
