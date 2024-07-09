package et.telebof.requests;

import et.telebof.types.ChatPermission;

public class RestrictChatMember extends AbstractBaseRequest<RestrictChatMember, Boolean> {

    public RestrictChatMember(Object chatId, long userId, ChatPermission permissions, RequestSender requestSender){
        super(chatId, requestSender, "restrictChatMember");
        parameters.put("user_id", userId);
        parameters.put("permissions", permissions);
    }


    public RestrictChatMember untilDate(long untilDate){
        parameters.put("until_date", untilDate);
        return this;
    }

}
