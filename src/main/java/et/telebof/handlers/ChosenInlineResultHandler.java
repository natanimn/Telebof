package et.telebof.handlers;

import et.telebof.TelegramContext;
import et.telebof.types.ChosenInlineResult;

@FunctionalInterface
public interface ChosenInlineResultHandler {
    void handle(TelegramContext ctx, ChosenInlineResult chosenInlineResult);
}
