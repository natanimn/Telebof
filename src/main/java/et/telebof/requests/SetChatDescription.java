package et.telebof.requests;

public class SetChatDescription extends AbstractBaseRequest<SetChatDescription, Boolean> {
    public SetChatDescription(Object chatId, String title, RequestSender requestSender) {
        super(chatId, requestSender, "setChatDescription");
        add("description", title);
    }

    @Override
    public Boolean bind() {
        return (Boolean) requestSender.makeRequest(this);
    }
}
