package et.telebof.requests;

public class LeaveChat extends AbstractBaseRequest<LeaveChat, Boolean> {
    public LeaveChat(Object chatId, RequestSender requestSender) {
        super(chatId, requestSender, "leaveChat");
    }

    @Override
    public Boolean bind() {
        return (Boolean) requestSender.makeRequest(this);
    }
}
