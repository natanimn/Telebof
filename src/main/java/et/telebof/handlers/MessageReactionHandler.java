package et.telebof.handlers;

import et.telebof.BotContext;
import et.telebof.types.MessageReactionUpdated;

@FunctionalInterface
public interface MessageReactionHandler {
    void handle(BotContext context, MessageReactionUpdated reaction_updated);

}
