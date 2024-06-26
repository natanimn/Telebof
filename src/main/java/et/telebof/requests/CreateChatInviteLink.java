package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.ChatInviteLink;

public class CreateChatInviteLink extends AbstractBaseRequest<CreateChatInviteLink, ChatInviteLink> {
    public CreateChatInviteLink(Object chatId, RequestSender requestSender) {
        super(chatId, requestSender, "createChatInviteLink");
    }
    public CreateChatInviteLink(Object chatId, RequestSender requestSender, String methodName){
        super(chatId, requestSender, methodName);
    }

    public CreateChatInviteLink name(String name) {
        return add("name", name);
    }

    public CreateChatInviteLink expireDate(int expireDate) {
        return add("expire_date", expireDate);
    }

    public CreateChatInviteLink memberLimit(int memberLimit) {
        return add("member_limit", memberLimit);
    }

    public CreateChatInviteLink createsJoinRequest(boolean createsJoinRequest) {
        return add("creates_join_request", createsJoinRequest);
    }

    @Override
    public ChatInviteLink exec() {
        return Util.parse(requestSender.makeRequest(this), ChatInviteLink.class);
    }
}
