package et.telebof.handlers;


import et.telebof.BotContext;
import et.telebof.types.CallbackQuery;

@FunctionalInterface
public interface CallbackHandler {
    void handle(BotContext context, CallbackQuery callbackQuery);
}
