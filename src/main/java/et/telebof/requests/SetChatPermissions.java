package et.telebof.requests;

import et.telebof.types.ChatPermission;

public class SetChatPermissions extends AbstractBaseRequest<SetChatPermissions, Boolean> {
    public SetChatPermissions(Object chatId, ChatPermission permissions, RequestSender requestSender) {
        super(chatId, requestSender, "setChatPermissions");
        add("permissions", permissions);
    }

}
