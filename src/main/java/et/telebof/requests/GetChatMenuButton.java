package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.MenuButton;

public class GetChatMenuButton extends AbstractBaseRequest<GetChatMenuButton, MenuButton> {
    public GetChatMenuButton(RequestSender requestSender) {
        super(requestSender, "getChatMenuButton", MenuButton.class);
    }

    public GetChatMenuButton chatId(long chatId) {
        return add("chat_id", chatId);
    }

}
