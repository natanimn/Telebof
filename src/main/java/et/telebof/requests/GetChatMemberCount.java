package et.telebof.requests;

public class GetChatMemberCount extends AbstractBaseRequest<GetChatMemberCount, Integer> {
    public GetChatMemberCount(Object chatId, RequestSender requestSender) {
        super(chatId, requestSender, "getChatMemberCount", Integer.class);
    }

}
