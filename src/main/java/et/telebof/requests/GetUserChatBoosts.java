package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.UserChatBoosts;

public class GetUserChatBoosts extends AbstractBaseRequest<GetUserChatBoosts, UserChatBoosts> {
    public GetUserChatBoosts(Object chat_id, long user_id, RequestSender requestSender){
        super(chat_id, requestSender, "getUserChatBoosts");
        add("user_id", user_id);
    }

    @Override
    public UserChatBoosts exec() {
        return Util.parse(requestSender.makeRequest(this), UserChatBoosts.class);
    }
}
