package et.telebof.handlers;

import et.telebof.types.Message;

@FunctionalInterface
public interface EditedMessageHandler {
    void handle(Message editedMessage);
}
