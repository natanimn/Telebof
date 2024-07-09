package et.telebof.requests;

import et.telebof.types.UserChatBoosts;

public class GetUserChatBoosts extends AbstractBaseRequest<GetUserChatBoosts, UserChatBoosts> {
    public GetUserChatBoosts(Object chat_id, long user_id, RequestSender requestSender){
        super(chat_id, requestSender, "getUserChatBoosts", UserChatBoosts.class);
        add("user_id", user_id);
    }

}
