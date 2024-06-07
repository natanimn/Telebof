package et.telebof.types;

import java.io.Serializable;

public class CallbackQuery extends JsonSerializable implements Serializable {
    public String id, inline_message_id, chat_instance, data, game_short_name;
    public User from;
    public Message message;

}
