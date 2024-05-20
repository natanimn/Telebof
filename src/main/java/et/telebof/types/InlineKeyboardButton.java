package et.telebof.types;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class InlineKeyboardButton implements Serializable {
    private final Map<String, Object> json = new TreeMap<>();
    private String text, url, callback_data, switch_inline_query_current_chat;
    private WebAppInfo wep_app;
    private LoginUrl login_url;
    private Boolean pay;
    private CallbackGame callback_game;

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

    public Map<String, Object> getJson() {
        return json;
    }
}
