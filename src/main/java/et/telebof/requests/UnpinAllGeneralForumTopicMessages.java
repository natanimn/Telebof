package et.telebof.requests;

public class UnpinAllGeneralForumTopicMessages extends AbstractBaseRequest<UnpinAllGeneralForumTopicMessages, Boolean>{
    public UnpinAllGeneralForumTopicMessages(Object chat_id, RequestSender requestSender){
        super(chat_id, requestSender, "unpinAllGeneralForumTopicMessages");
    }

}
