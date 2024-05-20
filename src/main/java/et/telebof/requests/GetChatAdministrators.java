package et.telebof.requests;

import et.telebof.Parser;
import et.telebof.types.ChatMember;

import java.util.List;

public class GetChatAdministrators extends AbstractBaseRequest<GetChatAdministrators, List<ChatMember>> {
    public GetChatAdministrators(Object chatId, RequestSender requestSender){
        super(chatId, requestSender, "getChatAdministrators");
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ChatMember> bind() {
        return Parser.parseList(Parser.parse(requestSender.makeRequest(this), List.class), ChatMember.class);
    }
}
