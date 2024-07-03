package et.telebof.types;

import java.io.Serializable;


public class KeyboardButtonRequestUsers implements Serializable {
    private Long request_id;
    private Boolean user_is_bot, user_is_premium;
    private Integer max_quantity;

    public KeyboardButtonRequestUsers(long requestId) {
        this.request_id = requestId;
    }

    public KeyboardButtonRequestUsers userIsBot(boolean userIsBot) {
        this.user_is_bot = userIsBot;
        return this;
    }

    public KeyboardButtonRequestUsers userIsPremium(boolean userIsPremium) {
        this.user_is_premium = userIsPremium;
        return this;
    }

    public KeyboardButtonRequestUsers maxQuantity(Integer max_quantity){
        this.max_quantity = max_quantity;
        return this;
    }

}
