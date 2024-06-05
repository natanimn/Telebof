package et.telebof.handlers;

import et.telebof.TelegramContext;
import et.telebof.types.ChatMemberUpdated;

@FunctionalInterface
public interface ChatMemberHandler {
    void handle(TelegramContext ctx, ChatMemberUpdated chatMemberUpdated);
}
