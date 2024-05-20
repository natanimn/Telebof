package et.telebof.types;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class ReplyKeyboardRemove implements Markup, Serializable {
    private boolean remove_keyboard;
    private boolean selective;
    private final Map<String, Object> json = new HashMap<>();
    public ReplyKeyboardRemove() {
        this.remove_keyboard = true;
        this.selective = false;
    }

    public ReplyKeyboardRemove selective(boolean selective) {
        this.selective = selective;
        return this;
    }

}
