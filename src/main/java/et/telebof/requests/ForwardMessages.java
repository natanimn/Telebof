package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.Message;
import et.telebof.types.MessageId;

import java.util.List;

public class ForwardMessages extends AbstractBaseRequest<ForwardMessages, List<MessageId>> {
    public ForwardMessages(Object chatId, Object fromChatId, List<Integer> messageIds, RequestSender requestSender) {
        super(chatId, requestSender, "forwardMessages");
        add("from_chat_id", fromChatId);
        add("message_id", messageIds);
    }

    public ForwardMessages messageThreadId(int messageThreadId) {
        return add("message_thread_id", messageThreadId);
    }

    public ForwardMessages disableNotification(boolean disableNotification) {
        return add("disable_notification", disableNotification);
    }

    public ForwardMessages protectContent(boolean protectContent) {
        return add("protect_content", protectContent);
    }

    @Override
    public List<MessageId> exec() {
        return Util.parse(requestSender.makeRequest(this), List.class);
    }


}
