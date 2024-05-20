package et.telebof.handlers;

import et.telebof.TelegramContext;
import et.telebof.types.InlineQuery;

@FunctionalInterface
public interface InlineHandler {
    void handle(TelegramContext ctx, InlineQuery inlineQuery);
}
