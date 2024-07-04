package et.telebof.handlers;

import et.telebof.BotContext;
import et.telebof.types.BusinessMessagesDeleted;
import et.telebof.types.Message;

@FunctionalInterface
public interface DeletedBusinessMessageHandler {
    void handle(BotContext context, BusinessMessagesDeleted deleted_business_message);
}
