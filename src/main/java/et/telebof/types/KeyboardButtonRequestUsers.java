package et.telebof.types;

import java.io.Serializable;


public class KeyboardButtonRequestUsers implements Serializable {
    private Long request_id;
    private Boolean user_is_bot, user_is_premium, request_name, request_username, request_photo;
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

    public  KeyboardButtonRequestUsers requestName(boolean request_name){
        this.request_name = request_name;
        return this;
    }

    public  KeyboardButtonRequestUsers requestUsername(boolean request_username){
        this.request_username = request_username;
        return this;
    }

    public  KeyboardButtonRequestUsers requestPhoto(boolean request_photo){
        this.request_photo = request_photo;
        return this;
    }

}
