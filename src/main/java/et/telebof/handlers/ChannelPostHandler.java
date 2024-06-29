package et.telebof.handlers;

import et.telebof.types.Message;

@FunctionalInterface
public interface ChannelPostHandler {
    void handle(Message message);
}
