package et.telebof.handlers;


import et.telebof.BotContext;
import et.telebof.types.ChatMemberUpdated;

@FunctionalInterface
public interface ChatMemberHandler {
    void handle(BotContext context, ChatMemberUpdated chatMemberUpdated);
}
