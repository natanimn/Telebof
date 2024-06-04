package et.telebof.types;

import java.io.Serializable;

public class InlineKeyboardButton implements Serializable {
    private String text, url, callback_data, switch_inline_query_current_chat;
    private WebAppInfo wep_app;
    private LoginUrl login_url;
    private Boolean pay;
    private CallbackGame callback_game;
    private SwitchInlineQueryChosenChat switch_inline_query_chosen_chat;

    public InlineKeyboardButton(String text) {
        this.text = text;
    }

    public InlineKeyboardButton url(String url) {
        this.url = url;
        return this;
    }

    public InlineKeyboardButton callbackData(String callbackData) {
        this.callback_data = callbackData;
        return this;
    }

    public InlineKeyboardButton webApp(WebAppInfo webApp) {
        this.wep_app = webApp;
        return this;
    }

    public InlineKeyboardButton loginUrl(LoginUrl loginUrl) {
        this.login_url = loginUrl;
        return this;
    }

    public InlineKeyboardButton switchInlineQueryCurrentChat(String switchInlineQueryCurrentChat) {
        this.switch_inline_query_current_chat = switchInlineQueryCurrentChat;
        return this;
    }

    public InlineKeyboardButton callbackGame(CallbackGame callbackGame) {
        this.callback_game = callbackGame;
        return this;
    }

    public InlineKeyboardButton pay(boolean pay) {
        this.pay = pay;
        return this;
    }

    public InlineKeyboardButton switchInlineQueryChosenChat(SwitchInlineQueryChosenChat chosenChat){
        this.switch_inline_query_chosen_chat = chosenChat;
        return this;
    }
}
