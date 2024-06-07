package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.ChatInviteLink;

public class RevokeChatInviteLink extends AbstractBaseRequest<RevokeChatInviteLink, ChatInviteLink> {
    public RevokeChatInviteLink(Object chatId, String inviteLink, RequestSender requestSender) {
        super(chatId, requestSender, "revokeChatInviteLink");
        add("invite_link", inviteLink);
    }

    @Override
    public ChatInviteLink exec() {
        return Util.parse(requestSender.makeRequest(this), ChatInviteLink.class);
    }
}
