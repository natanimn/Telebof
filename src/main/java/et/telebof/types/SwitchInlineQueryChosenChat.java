package et.telebof.types;

import java.io.Serializable;

public class SwitchInlineQueryChosenChat implements Serializable {
    private String query;
    private Boolean allow_user_chats, allow_bot_chats, allow_group_chats, allow_channel_chats;

    public SwitchInlineQueryChosenChat query(String query){
        this.query = query;
        return this;
    }

    public SwitchInlineQueryChosenChat allowUserChats(boolean allowUserChats){
        this.allow_user_chats = allowUserChats;
        return this;
    }

    public SwitchInlineQueryChosenChat allowBotChats(boolean allowBotChats){
        this.allow_bot_chats = allowBotChats;
        return this;
    }

    public SwitchInlineQueryChosenChat allowGroupChats(boolean allowGroupChats){
        this.allow_group_chats = allowGroupChats;
        return this;
    }

    public SwitchInlineQueryChosenChat allowChannelChats(boolean allowChannelChats){
        this.allow_channel_chats = allowChannelChats;
        return this;
    }
}
