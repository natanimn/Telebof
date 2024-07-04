package et.telebof.handlers;

import et.telebof.BotContext;
import et.telebof.types.Message;

@FunctionalInterface
public interface EditedChannelPostHandler {
    void handle(BotContext context, Message edited_channel_post);
}
