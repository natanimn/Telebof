package et.telebof.handlers;

import et.telebof.types.ChatMemberUpdated;

@FunctionalInterface
public interface MyChatMemberHandler {

    void handle(ChatMemberUpdated chatMemberUpdated);
}
