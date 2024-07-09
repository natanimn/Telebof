package et.telebof.requests;

public class UnpinAllForumTopicMessages extends AbstractBaseRequest<UnpinAllForumTopicMessages, Boolean> {
    public UnpinAllForumTopicMessages(Object chatId, int messageThreadId, RequestSender requestSender) {
        super(chatId, requestSender, "unpinAllForumTopicMessages");
        add("message_thread_id", messageThreadId);
    }

}
