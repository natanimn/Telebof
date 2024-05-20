package et.telebof.types;

public class BotCommandScopeChatMember extends BotCommandScope {
    private Object chat_id;
    public BotCommandScopeChatMember(Object chatId) {
        super("chat_member");
        this.chat_id = chatId;
    }
}
