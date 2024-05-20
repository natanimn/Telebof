package et.telebof.requests;

public class HideGeneralForumTopic extends AbstractBaseRequest<HideGeneralForumTopic, Boolean> {
    public HideGeneralForumTopic(Object chatId, RequestSender requestSender) {
        super(chatId, requestSender, "hideGeneralForumTopic");
    }

    @Override
    public Boolean bind() {
        return (Boolean) requestSender.makeRequest(this);
    }
}
