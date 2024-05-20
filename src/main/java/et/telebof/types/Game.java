package et.telebof.types;

import java.io.Serializable;
import java.util.List;

public class Game extends JsonSerializable implements Serializable {
    private String title, description;
    private List<PhotoSize> photo;
    private String text;
    private List<MessageEntity> text_entities;
    private Animation animation;

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public Animation getAnimation() {
        return animation;
    }

    public List<MessageEntity> getTextEntities() {
        return text_entities;
    }

    public List<PhotoSize> getPhoto() {
        return photo;
    }

    public String getText() {
        return text;
    }
}
