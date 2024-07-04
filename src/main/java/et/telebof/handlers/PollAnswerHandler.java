package et.telebof.handlers;

import et.telebof.BotContext;
import et.telebof.types.PollAnswer;

@FunctionalInterface
public interface PollAnswerHandler {
    void handle(BotContext context, PollAnswer poll_answer);
}
