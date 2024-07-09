package et.telebof.requests;

public class EditGeneralForumTopic extends AbstractBaseRequest<EditGeneralForumTopic, Boolean> {
    public EditGeneralForumTopic(Object chatId, String name, RequestSender requestSender) {
        super(chatId, requestSender, "editGeneralForumTopic");
        add("name", name);
    }

}
