package et.telebof.handlers;

import et.telebof.TelegramContext;
import et.telebof.types.PreCheckoutQuery;

public interface PreCheckoutHandler {
    void handle(TelegramContext ctx, PreCheckoutQuery preCheckoutQuery);
}
