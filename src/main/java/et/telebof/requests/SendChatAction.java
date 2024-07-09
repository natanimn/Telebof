package et.telebof.requests;

import et.telebof.enums.ChatAction;

public class SendChatAction extends AbstractBaseRequest<SendChatAction, Boolean> {

    public SendChatAction(Object chatId, ChatAction chatAction, RequestSender requestSender) {
        super(chatId, requestSender, "sendChatAction");
        add("chatAction", chatAction.name().toLowerCase());
    }

    public SendChatAction messageThreadId(int messageThreadId) {
        return add("message_thread_id", messageThreadId);
    }


    public SendChatAction businessConnectionId(String business_connection_id){
        return add("business_connection_id", business_connection_id);
    }

}
