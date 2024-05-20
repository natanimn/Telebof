package et.telebof.requests;

import et.telebof.Parser;
import et.telebof.types.GameHighScore;

import java.util.List;

public class GetGameHighScores extends AbstractBaseRequest<GetGameHighScores, List<GameHighScore>> {
    public GetGameHighScores(long chatId, long userId, int messageId, RequestSender requestSender) {
        super(chatId, requestSender, "getGameHighScores");
        add("user_id", userId);
        add("message_id", messageId);
    }

    public GetGameHighScores(String inlineMessageId, long userId, RequestSender requestSender) {
        super(requestSender, "getGameHighScores");
        add("user_id", userId);
        add("inline_message_id", inlineMessageId);

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<GameHighScore> bind() {
        return Parser.parseList(Parser.parse(requestSender.makeRequest(this), List.class), GameHighScore.class);
    }
}
