package et.telebof.requests;

public class UnHideGeneralForumTopic extends AbstractBaseRequest<UnHideGeneralForumTopic, Boolean> {
    public UnHideGeneralForumTopic(Object chatId, RequestSender requestSender) {
        super(chatId, requestSender, "unHideGeneralForumTopic");
    }

    @Override
    public Boolean exec() {
        Object response = requestSender.makeRequest(this);
        return (Boolean) response;
    }
}
