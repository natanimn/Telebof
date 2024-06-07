package et.telebof.requests;

public class ReopenGeneralForumTopic extends AbstractBaseRequest<ReopenGeneralForumTopic, Boolean> {
    public ReopenGeneralForumTopic(Object chatId, RequestSender requestSender) {
        super(chatId, requestSender, "reopenGeneralForumTopic");
    }

    @Override
    public Boolean exec() {
        return (Boolean) requestSender.makeRequest(this);
    }
}
