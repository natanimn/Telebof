package et.telebof.requests;

public class ExportChatInviteLink extends AbstractBaseRequest<ExportChatInviteLink, String> {
    public ExportChatInviteLink(Object chatId, RequestSender requestSender) {
        super(chatId, requestSender, "exportChatInviteLink", Object.class);
    }

}
