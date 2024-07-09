package et.telebof.requests;

public class LeaveChat extends AbstractBaseRequest<LeaveChat, Boolean> {
    public LeaveChat(Object chatId, RequestSender requestSender) {
        super(chatId, requestSender, "leaveChat");
    }

}
