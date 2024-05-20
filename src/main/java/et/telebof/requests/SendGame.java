package et.telebof.requests;

import et.telebof.types.Message;

public class SendGame extends DefaultParameters<SendGame, Message> {
    public SendGame(long chatId, String gameShortName, RequestSender requestSender) {
        super(chatId, requestSender, "sendGame");
        add("game_short_name", gameShortName);
    }

}
