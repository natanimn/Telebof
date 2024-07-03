package et.telebof.handlers;

import et.telebof.BotContext;
import et.telebof.types.MessageReactionCountUpdated;

@FunctionalInterface
public interface MessageReactionCountHandler {
    void handle(BotContext context, MessageReactionCountUpdated reaction_count_update);
}
