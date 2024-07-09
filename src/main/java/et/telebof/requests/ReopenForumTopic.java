package et.telebof.requests;

public class ReopenForumTopic extends AbstractBaseRequest<ReopenForumTopic, Boolean> {
    public ReopenForumTopic(Object chatId, int messageThreadId, RequestSender requestSender) {
        super(chatId, requestSender, "reopenForumTopic");
        add("message_thread_id", messageThreadId);
    }

}
