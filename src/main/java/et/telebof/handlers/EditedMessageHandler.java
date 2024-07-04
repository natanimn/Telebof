package et.telebof.handlers;

import et.telebof.BotContext;
import et.telebof.types.Message;

@FunctionalInterface
public interface EditedMessageHandler {
    void handle(BotContext context, Message edited_message);
}
