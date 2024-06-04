package et.telebof.requests;


public class EditChatInviteLink extends CreateChatInviteLink {
    public EditChatInviteLink(Object chatId, String inviteLink, RequestSender requestSender) {
        super(chatId, requestSender, "editChatInviteLink");
        add("invite_link", inviteLink);
    }

}
