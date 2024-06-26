package et.telebof.requests;

public class SetChatDescription extends AbstractBaseRequest<SetChatDescription, Boolean> {
    public SetChatDescription(Object chatId, String title, RequestSender requestSender) {
        super(chatId, requestSender, "setChatDescription");
        add("description", title);
    }

    @Override
    public Boolean exec() {
        Object response = requestSender.makeRequest(this);
        return (Boolean) response;
    }
}
