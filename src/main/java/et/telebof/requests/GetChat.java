package et.telebof.requests;

import et.telebof.Parser;
import et.telebof.types.Chat;

public class GetChat extends AbstractBaseRequest<GetChat, Chat> {
    public GetChat(Object chatId, RequestSender requestSender) {
        super(chatId, requestSender, "getChat");
    }

    @Override
    public Chat bind() {
        return Parser.parse(requestSender.makeRequest(this), Chat.class);
    }
}
