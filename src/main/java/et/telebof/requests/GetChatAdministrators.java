package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.ChatMember;

import java.util.List;

public class GetChatAdministrators extends AbstractBaseRequest<GetChatAdministrators, List<ChatMember>> {
    public GetChatAdministrators(Object chatId, RequestSender requestSender){
        super(chatId, requestSender, "getChatAdministrators");
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ChatMember> exec() {
        return Util.parseList(Util.parse(requestSender.makeRequest(this), List.class), ChatMember.class);
    }
}
