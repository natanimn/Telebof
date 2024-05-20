package et.telebof.handlers;

import et.telebof.TelegramContext;
import et.telebof.types.ShippingQuery;

@FunctionalInterface
public interface ShippingHandler {
    boolean handle(TelegramContext ctx, ShippingQuery shippingQuery);
}
