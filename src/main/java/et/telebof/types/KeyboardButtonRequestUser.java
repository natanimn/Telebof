package et.telebof.types;

import java.io.Serializable;


public class KeyboardButtonRequestUser implements Serializable {
    public Long request_id;
    public Boolean user_is_bot, user_is_premium;

    public KeyboardButtonRequestUser(long requestId) {
        this.request_id = requestId;
    }

    public KeyboardButtonRequestUser userIsBot(boolean userIsBot) {
        this.user_is_bot = userIsBot;
        return this;
    }

    public KeyboardButtonRequestUser userIsPremium(boolean userIsPremium) {
        this.user_is_premium = userIsPremium;
        return this;
    }

}
