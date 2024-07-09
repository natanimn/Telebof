package et.telebof.requests;

import com.google.gson.reflect.TypeToken;
import et.telebof.types.BotCommand;
import et.telebof.types.BotCommandScope;
import java.lang.reflect.Type;
import java.util.List;

public class GetMyCommands extends AbstractBaseRequest<GetMyCommands, List<BotCommand> > {

    private static final Type responseType = TypeToken.getParameterized(List.class, BotCommand.class).getType();

    public GetMyCommands(RequestSender requestSender) {
        super(requestSender, "getMyCommands", responseType);
    }

    public GetMyCommands scope(BotCommandScope botCommandScope) {
        return add("scope", botCommandScope);
    }

    public GetMyCommands languageCode(String languageCode) {
        return add("language_code", languageCode);
    }

}
