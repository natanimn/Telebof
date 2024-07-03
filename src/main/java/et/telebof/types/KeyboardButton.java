package et.telebof.types;

import java.io.Serializable;

public class KeyboardButton implements Serializable {
    private String text;
    private KeyboardButtonRequestUsers request_users;
    private KeyboardButtonRequestChat request_chat;
    private KeyboardButtonPollType request_poll;
    private Boolean request_contact, request_location;
    private WebAppInfo wep_app;


    public KeyboardButton(String text) {
        this.text = text;
    }

    public KeyboardButton requestUser(KeyboardButtonRequestUsers requestUsers) {
        this.request_users = requestUsers;
        return this;
    }

    public KeyboardButton requestChat(KeyboardButtonRequestChat requestChat) {
        this.request_chat = requestChat;
        return this;
    }

    public KeyboardButton requestContact(boolean requestContact) {
        this.request_contact = requestContact;
        return this;
    }

    public KeyboardButton requestLocation(boolean requestLocation) {
        this.request_location = requestLocation;
        return this;
    }

    public KeyboardButton requestPoll(KeyboardButtonPollType requestPoll) {
        this.request_poll = requestPoll;
        return this;
    }

    public KeyboardButton webApp(WebAppInfo webApp) {
        this.wep_app = webApp;
        return this;
    }

}
