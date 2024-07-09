package et.telebof.requests;

public class UnbanChatSenderChat extends AbstractBaseRequest<UnbanChatSenderChat, Boolean> {
    public UnbanChatSenderChat(Object chatId, long senderChatId, RequestSender requestSender) {
        super(chatId, requestSender, "unbanChatSenderChat");
        add("sender_chat_id", senderChatId);
    }

}
