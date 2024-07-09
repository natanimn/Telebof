package et.telebof.requests;

import com.google.gson.reflect.TypeToken;
import et.telebof.Util;
import et.telebof.types.ChatMember;
import et.telebof.types.Update;

import java.lang.reflect.Type;
import java.util.List;

public class GetChatAdministrators extends AbstractBaseRequest<GetChatAdministrators, List<ChatMember>> {

    private static final Type responseType = TypeToken.getParameterized(List.class, ChatMember.class).getType();
    public GetChatAdministrators(Object chatId, RequestSender requestSender){
        super(chatId, requestSender, "getChatAdministrators", responseType);
    }

}
