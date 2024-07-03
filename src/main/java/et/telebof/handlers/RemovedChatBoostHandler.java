package et.telebof.handlers;

import et.telebof.BotContext;
import et.telebof.types.ChatBoostRemoved;

@FunctionalInterface
public interface RemovedChatBoostHandler {
    void handle(BotContext context, ChatBoostRemoved removed_chat_boost);
}
