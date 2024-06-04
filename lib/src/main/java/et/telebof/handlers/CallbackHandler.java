package et.telebof.handlers;

import et.telebof.TelegramContext;
import et.telebof.types.CallbackQuery;

@FunctionalInterface
public interface CallbackHandler {
    void handle(TelegramContext ctx, CallbackQuery callbackQuery);
}
