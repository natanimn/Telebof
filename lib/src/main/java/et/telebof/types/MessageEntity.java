package et.telebof.types;

import et.telebof.enums.EntityType;
import java.io.Serializable;


/**
 * @author Natanim Negash
 */


public class MessageEntity extends JsonSerializable implements Serializable {
    private String url, language, type;
    private Integer offset, length;
    private User user;
    private String custom_emoji_id;

    public MessageEntity type(EntityType type) {
        this.type = type.name().toLowerCase();
        return this;
    }

    public MessageEntity offset(int offset) {
        this.offset = offset;
        return this;
    }

    public MessageEntity length(int length) {
        this.length = length;
        return this;
    }

    public MessageEntity url(String url) {
        this.url = url;
        return this;
    }

    public MessageEntity user(User user) {
        this.user = user;
        return this;
    }

    public MessageEntity language(String language) {
        this.language = language;
        return this;

    }

    public MessageEntity customEmojiId(String customEmojiId) {
        this.custom_emoji_id = customEmojiId;
        return this;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public String getLanguage() {
        return language;
    }

    public Integer getOffset() {
        return offset;
    }

    public Integer getLength() {
        return length;
    }

    public User getUser() {
        return user;
    }

    public String getCustomEmojiId() {
        return custom_emoji_id;
    }
}