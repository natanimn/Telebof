package et.telebof.requests;

public class ApproveChatJoinRequest extends AbstractBaseRequest<ApproveChatJoinRequest, Boolean> {
    public ApproveChatJoinRequest(Object chatId, long userId, RequestSender requestSender) {
        super(chatId, requestSender, "approveChatJoinRequest");
        add("user_id", userId);
    }

}

