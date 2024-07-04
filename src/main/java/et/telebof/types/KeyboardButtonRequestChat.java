package et.telebof.types;

import java.util.Map;
import java.util.TreeMap;

public class KeyboardButtonRequestChat extends JsonSerializable {
    private ChatAdministratorRights user_administrator_rights, bot_administrator_rights;
    private Boolean bot_is_member, chat_is_forum, chat_has_username, chat_is_created, chat_is_channel, request_name,
    request_title, request_username, request_photo;
    private Integer request_id;

    public KeyboardButtonRequestChat(int requestId) {
        this.request_id = requestId;
    }
    
    public KeyboardButtonRequestChat chatIsChannel(boolean chatIsChannel) {
        this.chat_is_channel = chatIsChannel;
        return this;
    }

    public KeyboardButtonRequestChat chatIsForum(boolean chatIsForum) {
        this.chat_is_forum = chatIsForum;
        return this;
    }

    public KeyboardButtonRequestChat chatHasUsername(boolean chatHasUsername) {
        this.chat_has_username = chatHasUsername;
        return this;
    }

    public KeyboardButtonRequestChat chatIsCreated(boolean chatIsCreated) {
        this.chat_is_created = chatIsCreated;
        return this;
    }

    public KeyboardButtonRequestChat userAdministratorRights(ChatAdministratorRights userAdministratorRights) {
        this.user_administrator_rights = userAdministratorRights;
        return this;
    }

    public KeyboardButtonRequestChat botAdministratorRights(ChatAdministratorRights botAdministratorRights) {
        this.bot_administrator_rights = botAdministratorRights;
        return this;
    }

    public KeyboardButtonRequestChat botIsMember(boolean botIsMember) {
        this.bot_is_member = botIsMember;
        return this;
    }

    public  KeyboardButtonRequestChat requestName(boolean request_name){
        this.request_name = request_name;
        return this;
    }

    public  KeyboardButtonRequestChat requestTitle(boolean request_title){
        this.request_title = request_title;
        return this;
    }

    public  KeyboardButtonRequestChat requestUsername(boolean request_username){
        this.request_username = request_username;
        return this;
    }

    public  KeyboardButtonRequestChat requestPhoto(boolean request_photo){
        this.request_photo = request_photo;
        return this;
    }

}
