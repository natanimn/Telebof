package et.telebof.handlers;

import et.telebof.BotContext;
import et.telebof.types.Message;

@FunctionalInterface
public interface BusinessMessageHandler {
    void handle(BotContext context, Message business_message);
}
