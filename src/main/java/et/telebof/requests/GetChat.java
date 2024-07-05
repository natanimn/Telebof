package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.ChatFullInfo;

public class GetChat extends AbstractBaseRequest<GetChat, ChatFullInfo> {
    public GetChat(Object chatId, RequestSender requestSender) {
        super(chatId, requestSender, "getChat");
    }

    @Override
    public ChatFullInfo exec() {
        return Util.parse(requestSender.makeRequest(this), ChatFullInfo.class);
    }
}
