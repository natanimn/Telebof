package et.telebof.handlers;


import et.telebof.types.ChatMemberUpdated;

@FunctionalInterface
public interface ChatMemberHandler {
    void handle(ChatMemberUpdated chatMemberUpdated);
}
