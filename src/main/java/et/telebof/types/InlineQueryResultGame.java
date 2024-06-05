package et.telebof.types;

import java.io.Serializable;

public class InlineQueryResultGame implements Serializable, InlineQueryResult {
    private String id, type, game_short_name;
    private InlineKeyboardMarkup reply_markup;
    public InlineQueryResultGame(String id) {
        this.type = "game";
        this.id = id;
    }

    public InlineQueryResultGame gameShortName(String gameShortName) {
        this.game_short_name = gameShortName;
        return this;
    }

    public InlineQueryResultGame replyMarkup(InlineKeyboardMarkup keyboard) {
        this.reply_markup = keyboard;
        return this;
    }
}
