package et.telebof.handlers;

import et.telebof.types.PollAnswer;

@FunctionalInterface
public interface PollAnswerHandler {
    void handle(PollAnswer pollAnswer);
}
