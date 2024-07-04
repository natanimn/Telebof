package et.telebof.handlers;

import et.telebof.BotContext;
import et.telebof.types.ShippingQuery;

@FunctionalInterface
public interface ShippingHandler {
    boolean handle(BotContext context, ShippingQuery shipping_query);
}
