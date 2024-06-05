package et.telebof.types;


import et.telebof.BotLog;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class InlineKeyboardMarkup implements Markup, Serializable {
    transient private final Map<String, Object> json = new HashMap<>();
    private final List<List<InlineKeyboardButton>> inline_keyboard = new ArrayList<>();
    transient private String text, url, callback_data;
    transient private LoginUrl login_url;
    transient private WebAppInfo web_app;
    transient private String switch_inline_query, switch_inline_query_current_chat;
    transient private CallbackGame callback_game;
    transient private Boolean pay;
    transient private int rowWidth = 3;

    public String getText() {
        return text;
    }

    public String getUrl() {
        return url;
    }

    public String getCallbackData() {
        return callback_data;
    }

    public LoginUrl getLoginUrl() {
        return login_url;
    }

    public WebAppInfo getWebApp() {
        return web_app;
    }

    public String getSwitchInlineQuery() {
        return switch_inline_query;
    }

    public String getSwitchInlineQueryCurrentChat() {
        return switch_inline_query_current_chat;
    }

    public CallbackGame getCallbackGame() {
        return callback_game;
    }

    public Boolean getPay() {
        return pay;
    }

    public InlineKeyboardMarkup(){}

    public InlineKeyboardMarkup(InlineKeyboardButton[][]  keyboard) {
        List<InlineKeyboardButton[]> lists = Arrays.stream(keyboard).toList();
        lists.forEach(value -> {
            inline_keyboard.add(List.of(value));
        });
    }


    public InlineKeyboardMarkup(InlineKeyboardButton[] buttons, int rowWidth){
        if (rowWidth > 8) {
            BotLog.warn("Currently telegram supports 8 inline keyboard rowWidth at maximum");
            rowWidth = 8;
        }

        List<InlineKeyboardButton> keyboard = List.of(buttons);
        for (int i =0; i < keyboard.size(); i+=rowWidth) {
            try {
                inline_keyboard.add(keyboard.subList(i, i + rowWidth));
            } catch (IndexOutOfBoundsException exception) {
                inline_keyboard.add(keyboard.subList(i, keyboard.size()));
            }
        }
    }

    public InlineKeyboardMarkup(InlineKeyboardButton[] buttons){
        this(buttons, Math.min(buttons.length, 8));
    }



    public void addKeyboard(InlineKeyboardButton... buttons){
        int length = buttons.length;
        List<InlineKeyboardButton> buttonList = List.of(buttons);
        if (length > 8){
            for (int i =0; i < length; i+=rowWidth){
                try {
                    inline_keyboard.add(buttonList.subList(i, i + rowWidth));
                } catch (IndexOutOfBoundsException exception) {
                    inline_keyboard.add(buttonList.subList(i, length));
                }
            }

        } else {
            inline_keyboard.add(buttonList);
        }
    }

    public void rowWidth(int rowWidth) {
        this.rowWidth = rowWidth;
    }


}
