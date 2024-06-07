package et.telebof.types;

import et.telebof.enums.EntityType;
import java.io.Serializable;


/**
 * @author Natanim Negash
 */


public class MessageEntity extends JsonSerializable implements Serializable {
    public String url, language, type;
    public Integer offset, length;
    public User user;
    public String custom_emoji_id;

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

}