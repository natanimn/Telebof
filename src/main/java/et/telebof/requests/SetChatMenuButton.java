package et.telebof.requests;

import et.telebof.types.MenuButton;

public class SetChatMenuButton extends AbstractBaseRequest<SetChatMenuButton, Boolean> {
    public SetChatMenuButton(RequestSender requestSender) {
        super(requestSender, "setChatMenuButton");
    }

    public SetChatMenuButton chatId(long chatId) {
        return add("chat_id", chatId);
    }

    public SetChatMenuButton menuButton(MenuButton menuButton) {
        return add("menu_button", menuButton);
    }

}
