package et.telebof.handlers;

import et.telebof.TelegramContext;
import et.telebof.types.Message;

@FunctionalInterface
public interface EditedMessageHandler {
    void handle(TelegramContext ctx, Message editedMessage);
}
