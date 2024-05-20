package et.telebof.handlers;

import et.telebof.TelegramContext;
import et.telebof.types.PollAnswer;

@FunctionalInterface
public interface PollAnswerHandler {
    void handle(TelegramContext ctx, PollAnswer pollAnswer);
}
