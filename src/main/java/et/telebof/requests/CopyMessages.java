package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.MessageEntity;
import et.telebof.types.MessageId;

import java.util.List;

public class CopyMessages extends AbstractBaseRequest<CopyMessages, List<MessageId>> {

    public CopyMessages(Object chatId, Object fromChatId, List<Integer> messageIds, RequestSender requestSender) {
        super(chatId, requestSender, "copyMessages");
        add("from_chat_id", fromChatId);
        add("message_id", messageIds);
    }

    public CopyMessages caption(String cap) {
        return add("caption", cap);
    }

    public CopyMessages captionEntities(MessageEntity[] captionEntities) {
        return add("caption_entities", List.of(captionEntities));
    }

    @Override
    public List<MessageId> exec() {
        return Util.parse(requestSender.makeRequest(this), List.class);
    }

}
