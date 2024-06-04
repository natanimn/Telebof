package et.telebof.handlers;

import et.telebof.TelegramContext;
import et.telebof.types.ChatJoinRequest;

@FunctionalInterface
public interface ChatJoinRequestHandler {
    boolean handle(TelegramContext ctx, ChatJoinRequest chatJoinRequest);
}
