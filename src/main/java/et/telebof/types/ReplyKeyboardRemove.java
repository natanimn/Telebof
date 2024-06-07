package et.telebof.types;

import java.io.Serializable;

@SuppressWarnings("unused")
public class ReplyKeyboardRemove implements Markup, Serializable {
    private final boolean remove_keyboard;
    private boolean selective;
    public ReplyKeyboardRemove() {
        this.remove_keyboard = true;
        this.selective = false;
    }

    public ReplyKeyboardRemove selective(boolean selective) {
        this.selective = selective;
        return this;
    }

}
