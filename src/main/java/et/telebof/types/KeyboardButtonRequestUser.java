package et.telebof.types;

import java.io.Serializable;


public class KeyboardButtonRequestUser implements Serializable {
    private Long request_id;
    private Boolean user_is_bot, user_is_premium;

    public Boolean getUserIsBot() {
        return user_is_bot;
    }

    public Long getRequestId() {
        return request_id;
    }

    public Boolean getUserIsPremium() {
        return user_is_premium;
    }

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
