package et.telebof.handlers;

import et.telebof.types.PreCheckoutQuery;

public interface PreCheckoutHandler {
    void handle(PreCheckoutQuery preCheckoutQuery);
}
