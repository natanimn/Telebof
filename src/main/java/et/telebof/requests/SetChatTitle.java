package et.telebof.requests;

public class SetChatTitle extends AbstractBaseRequest<SetChatTitle, Boolean> {
    public SetChatTitle(Object chatId, String title, RequestSender requestSender) {
        super(chatId, requestSender, "setChatTitle");
        add("title", title);
    }

}
