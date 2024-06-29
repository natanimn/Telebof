package et.telebof.handlers;

import et.telebof.types.ChatJoinRequest;

@FunctionalInterface
public interface ChatJoinRequestHandler {
    boolean handle(ChatJoinRequest chatJoinRequest);
}
