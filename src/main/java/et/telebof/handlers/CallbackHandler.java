package et.telebof.handlers;


import et.telebof.types.CallbackQuery;

@FunctionalInterface
public interface CallbackHandler {
    void handle(CallbackQuery callbackQuery);
}
