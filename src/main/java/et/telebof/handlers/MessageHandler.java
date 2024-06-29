package et.telebof.handlers;

import et.telebof.types.Message;

@FunctionalInterface
public interface MessageHandler {
    void handle(Message message);
}
