package et.telebof.types;

import java.io.Serializable;


public class LoginUrl implements Serializable {
    public String url, forwardText, botUsername;
    public Boolean requestWriteAccess;

    private String forward_text, bot_username;
    private Boolean request_write_access;


    public LoginUrl url(String url){
        this.url = url;
        return this;
    }

    public LoginUrl forwardText(String forwardText){
        this.forward_text = forwardText;
        return this;
    }

    public LoginUrl botUsername(String botUsername){
        this.bot_username = botUsername;
        return this;
    }

    public LoginUrl requestWriteAccess(boolean requestWriteAccess){
        this.request_write_access = requestWriteAccess;
        return this;
    }

}
