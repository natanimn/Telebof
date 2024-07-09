package et.telebof.requests;

public class PinChatMessage extends AbstractBaseRequest<PinChatMessage, Boolean> {
    public PinChatMessage(Object chatId, int messageId, RequestSender requestSender) {
        super(chatId, requestSender, "pinChatMessage");
        add("message_id", messageId);
    }

    public PinChatMessage disableNotification(boolean disableNotification) {
        return add("disable_notification", disableNotification);
    }

}
