package et.telebof.requests;

public class CloseGeneralForumTopic extends AbstractBaseRequest<CloseGeneralForumTopic, Boolean> {
    public CloseGeneralForumTopic(Object chatId, RequestSender requestSender) {
        super(chatId, requestSender, "closeGeneralForumTopic");
    }

}
