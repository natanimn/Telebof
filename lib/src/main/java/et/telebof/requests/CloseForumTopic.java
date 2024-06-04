package et.telebof.requests;

public class CloseForumTopic extends AbstractBaseRequest<Close, Boolean> {
    public CloseForumTopic(Object chatId, int messageThreadId, RequestSender requestSender) {
        super(chatId, requestSender, "closeForumTopic");
        add("message_thread_id", messageThreadId);
    }

    @Override
    public Boolean bind() {
        return (Boolean) requestSender.makeRequest(this);
    }
}
