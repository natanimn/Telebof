package et.telebof.handlers;

import et.telebof.BotContext;
import et.telebof.types.BusinessConnection;

@FunctionalInterface
public interface BusinessConnectionHandler {
    void handle(BotContext context, BusinessConnection connection);
}
