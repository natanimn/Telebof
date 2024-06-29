package et.telebof.handlers;


import et.telebof.types.ChosenInlineResult;

@FunctionalInterface
public interface ChosenInlineResultHandler {
    void handle(ChosenInlineResult chosenInlineResult);
}
