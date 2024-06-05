package et.telebof.types;

public class ForumTopic {
    private Integer message_thread_id, icon_color;
    private String name, icon_custom_emoji_id;

    public String getName() {
        return name;
    }

    public Integer getIconColor() {
        return icon_color;
    }

    public Integer getMessageThreadId() {
        return message_thread_id;
    }

    public String getIconCustomEmojiId() {
        return icon_custom_emoji_id;
    }


}
