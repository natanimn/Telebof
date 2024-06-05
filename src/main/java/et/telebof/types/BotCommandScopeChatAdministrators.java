package et.telebof.types;

public class BotCommandScopeChatAdministrators extends BotCommandScope {
    private Object chat_id;
    public BotCommandScopeChatAdministrators(Object chatId) {
        super("chat_administrators");
        this.chat_id = chatId;
    }
}
