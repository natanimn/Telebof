package et.telebof.handlers;

import et.telebof.BotContext;
import et.telebof.types.PreCheckoutQuery;

public interface PreCheckoutHandler {
    void handle(BotContext context, PreCheckoutQuery pre_checkout_query);
}
