package et.telebof.requests;

import et.telebof.types.BotCommandScope;

public class DeleteMyCommands extends AbstractBaseRequest<DeleteMyCommands, Boolean> {
    public DeleteMyCommands(RequestSender requestSender) {
        super(requestSender, "deleteMyCommands");
    }

    public DeleteMyCommands scope(BotCommandScope botCommandScope) {
        return add("scope", botCommandScope);
    }

    public DeleteMyCommands languageCode(String languageCode) {
        return add("language_code", languageCode);
    }

    @Override
    public Boolean exec() {
        Object response = requestSender.makeRequest(this);
        return (Boolean) response;
    }
}
