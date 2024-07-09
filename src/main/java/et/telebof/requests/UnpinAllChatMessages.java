package et.telebof.requests;

public class UnpinAllChatMessages extends AbstractBaseRequest<UnpinAllChatMessages, Boolean> {
    public UnpinAllChatMessages(Object chatId, RequestSender requestSender) {
        super(chatId, requestSender, "unpinAllChatMessages");
    }

}
