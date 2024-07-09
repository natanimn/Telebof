package et.telebof.requests;

import et.telebof.types.ChatInviteLink;

public class RevokeChatInviteLink extends AbstractBaseRequest<RevokeChatInviteLink, ChatInviteLink> {
    public RevokeChatInviteLink(Object chatId, String inviteLink, RequestSender requestSender) {
        super(chatId, requestSender, "revokeChatInviteLink", ChatInviteLink.class);
        add("invite_link", inviteLink);
    }

}
