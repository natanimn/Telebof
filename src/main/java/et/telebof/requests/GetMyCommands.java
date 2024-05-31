package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.BotCommand;
import et.telebof.types.BotCommandScope;

import java.util.List;

public class GetMyCommands extends AbstractBaseRequest<GetMyCommands, List<BotCommand> > {
    public GetMyCommands(RequestSender requestSender) {
        super(requestSender, "getMyCommands");
    }

    public GetMyCommands scope(BotCommandScope botCommandScope) {
        return add("scope", botCommandScope);
    }

    public GetMyCommands languageCode(String languageCode) {
        return add("language_code", languageCode);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<BotCommand> bind() {
        return Util.parseList(Util.parse(requestSender.makeRequest(this), List.class), BotCommand.class);
    }
}
