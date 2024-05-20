package et.telebof.requests;

import et.telebof.Parser;
import et.telebof.types.Message;

public class ForwardMessage extends AbstractBaseRequest<ForwardMessage, Message> {
    public ForwardMessage(Object chatId, Object fromChatId, int messageId, RequestSender requestSender) {
        super(chatId, requestSender, "forwardMessage");
        add("from_chat_id", fromChatId);
        add("message_id", messageId);
    }

    public ForwardMessage messageThreadId(int messageThreadId) {
        return add("message_thread_id", messageThreadId);
    }

    public ForwardMessage disableNotification(boolean disableNotification) {
        return add("disable_notification", disableNotification);
    }

    public ForwardMessage protectContent(boolean protectContent) {
        return add("protect_content", protectContent);
    }

    @Override
    public Message bind() {
        return Parser.parse(requestSender.makeRequest(this), Message.class);
    }
}

