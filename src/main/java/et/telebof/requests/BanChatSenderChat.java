package et.telebof.requests;

public class BanChatSenderChat extends AbstractBaseRequest<BanChatSenderChat, Boolean> {
    public BanChatSenderChat(Object chatId, long senderChatId, RequestSender requestSender) {
        super(chatId, requestSender, "banChatSenderChat");
        add("sender_chat_id", senderChatId);
    }

}
