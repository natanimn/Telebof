package et.telebof.handlers;

import et.telebof.BotContext;
import et.telebof.types.ChatJoinRequest;

@FunctionalInterface
public interface ChatJoinRequestHandler {
    boolean handle(BotContext context, ChatJoinRequest chatJoinRequest);
}
