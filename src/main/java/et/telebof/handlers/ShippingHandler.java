package et.telebof.handlers;

import et.telebof.types.ShippingQuery;

@FunctionalInterface
public interface ShippingHandler {
    boolean handle(ShippingQuery shippingQuery);
}
