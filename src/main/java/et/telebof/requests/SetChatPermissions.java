package et.telebof.requests;

import et.telebof.types.ChatPermission;

public class SetChatPermissions extends AbstractBaseRequest<SetChatPermissions, Boolean> {
    public SetChatPermissions(Object chatId, ChatPermission permissions, RequestSender requestSender) {
        super(chatId, requestSender, "setChatPermissions");
        add("permissions", permissions);
    }

    @Override
    public Boolean exec() {
        Object response = requestSender.makeRequest(this);
        return (Boolean) response;
    }
}
