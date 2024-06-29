package et.telebof.requests;

public class UnpinAllGeneralForumTopicMessages extends AbstractBaseRequest<UnpinAllGeneralForumTopicMessages, Boolean>{
    public UnpinAllGeneralForumTopicMessages(Object chat_id, RequestSender requestSender){
        super(chat_id, requestSender, "unpinAllGeneralForumTopicMessages");
    }

    @Override
    public Boolean exec() {
        return (Boolean) requestSender.makeRequest(this);
    }
}
