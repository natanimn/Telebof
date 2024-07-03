package et.telebof.handlers;

import et.telebof.BotContext;
import et.telebof.types.ChatBoostUpdated;

@FunctionalInterface
public interface ChatBoostHandler {
    void handle(BotContext context, ChatBoostUpdated chat_boost);
}
