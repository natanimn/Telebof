package et.telebof.handlers;

import et.telebof.BotContext;
import et.telebof.types.ChatMemberUpdated;

@FunctionalInterface
public interface MyChatMemberHandler {
    void handle(BotContext context, ChatMemberUpdated chat_member_updated);
}
