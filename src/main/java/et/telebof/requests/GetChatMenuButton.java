package et.telebof.requests;

import et.telebof.Parser;
import et.telebof.types.MenuButton;

public class GetChatMenuButton extends AbstractBaseRequest<GetChatMenuButton, MenuButton> {
    public GetChatMenuButton(RequestSender requestSender) {
        super(requestSender, "getChatMenuButton");
    }

    public GetChatMenuButton chatId(long chatId) {
        return add("chat_id", chatId);
    }

    @Override
    public MenuButton bind() {
        return Parser.parse(requestSender.makeRequest(this), MenuButton.class);
    }
}
