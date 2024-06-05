package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.ChatMember;

public class GetChatMember extends AbstractBaseRequest<GetChatMember, ChatMember> {
    public GetChatMember(Object chatId, long userId, RequestSender requestSender) {
        super(chatId, requestSender, "getChatMember");
        add("user_id", userId);
    }

    @Override
    public ChatMember bind() {
        return Util.parse(requestSender.makeRequest(this), ChatMember.class);
    }
}
