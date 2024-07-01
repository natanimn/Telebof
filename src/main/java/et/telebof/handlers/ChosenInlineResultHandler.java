package et.telebof.handlers;


import et.telebof.BotContext;
import et.telebof.types.ChosenInlineResult;

@FunctionalInterface
public interface ChosenInlineResultHandler {
    void handle(BotContext context, ChosenInlineResult chosenInlineResult);
}
