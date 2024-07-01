package et.telebof.handlers;

import et.telebof.BotContext;
import et.telebof.types.Poll;

public interface PollHandler {
    void handle(BotContext context, Poll poll);
}
