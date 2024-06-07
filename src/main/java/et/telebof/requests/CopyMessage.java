package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.MessageEntity;
import et.telebof.types.MessageId;

import java.util.List;

public class CopyMessage extends DefaultParameters<CopyMessage, MessageId> {

    public CopyMessage(Object chat, Object fromChatId, int messageId, RequestSender requestSender) {
        super(chat, requestSender, "copyMessage");
        add("from_chat_id", fromChatId);
        add("message_id", messageId);
    }

    public CopyMessage caption(String cap) {
        return add("caption", cap);
    }

    public CopyMessage captionEntities(MessageEntity[] captionEntities) {
        return add("caption_entities", List.of(captionEntities));
    }

    @Override
    public MessageId exec() {
        return Util.parse(requestSender.makeRequest(this), MessageId.class);
    }
}
