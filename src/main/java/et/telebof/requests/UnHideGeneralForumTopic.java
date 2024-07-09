package et.telebof.requests;

public class UnHideGeneralForumTopic extends AbstractBaseRequest<UnHideGeneralForumTopic, Boolean> {
    public UnHideGeneralForumTopic(Object chatId, RequestSender requestSender) {
        super(chatId, requestSender, "unHideGeneralForumTopic");
    }

}
