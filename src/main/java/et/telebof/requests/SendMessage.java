package et.telebof.requests;

import et.telebof.Parser;
import et.telebof.types.Message;
import et.telebof.types.MessageEntity;

import java.util.List;

public class SendMessage extends DefaultParameters<SendMessage, Message> {
    public SendMessage(Object chatId,  String text, RequestSender requestSender) {
        super(chatId, requestSender, "sendMessage");
        add("text", text);
        add("allow_sending_without_reply", true);
    }

    public SendMessage entities(MessageEntity ... entities) {
        return add("entities", List.of(entities));
    }

    @Override
    public Message bind() {
        return Parser.parse(requestSender.makeRequest(this), Message.class);
    }
}
