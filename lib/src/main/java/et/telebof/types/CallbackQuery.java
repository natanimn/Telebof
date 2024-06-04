package et.telebof.types;

import java.io.Serializable;

public class CallbackQuery extends JsonSerializable implements Serializable {
    private String id, inline_message_id, chat_instance, data, game_short_name;
    private User from;
    private Message message;

    public String getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public User getFrom() {
        return from;
    }

    public String getInlineMessageId() {
        return inline_message_id;
    }

    public Message getMessage() {
        return message;
    }

    public String getChatInstance() {
        return chat_instance;
    }

    public String getGameShortName() {
        return game_short_name;
    }

}
