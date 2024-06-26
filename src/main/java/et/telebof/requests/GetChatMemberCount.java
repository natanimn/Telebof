package et.telebof.requests;

public class GetChatMemberCount extends AbstractBaseRequest<GetChatMemberCount, Integer> {
    public GetChatMemberCount(Object chatId, RequestSender requestSender) {
        super(chatId, requestSender, "getChatMemberCount");
    }

    @Override
    public Integer exec() {
        return (Integer) requestSender.makeRequest(this);
    }
}
