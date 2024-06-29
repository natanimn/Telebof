package et.telebof.handlers;

import et.telebof.types.Message;

@FunctionalInterface
public interface EditedChannelPostHandler {
    void handle(Message editedChannelPost);
}
