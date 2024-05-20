package et.telebof.handlers;

import et.telebof.TelegramContext;
import et.telebof.types.Poll;

public interface PollHandler {
    void handle(TelegramContext ctx, Poll poll);
}
