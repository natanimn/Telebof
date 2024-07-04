package et.telebof.handlers;

import et.telebof.BotContext;
import et.telebof.types.InlineQuery;

@FunctionalInterface
public interface InlineHandler {
    void handle(BotContext context, InlineQuery inline_query);
}
