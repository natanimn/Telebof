package et.telebof.handlers;

import et.telebof.types.InlineQuery;

@FunctionalInterface
public interface InlineHandler {
    void handle(InlineQuery inlineQuery);
}
