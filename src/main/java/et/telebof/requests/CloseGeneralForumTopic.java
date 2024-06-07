package et.telebof.requests;

public class CloseGeneralForumTopic extends AbstractBaseRequest<CloseGeneralForumTopic, Boolean> {
    public CloseGeneralForumTopic(Object chatId, RequestSender requestSender) {
        super(chatId, requestSender, "closeGeneralForumTopic");
    }

    @Override
    public Boolean exec() {
        Object response = requestSender.makeRequest(this);
        return (Boolean) response;
    }
}
