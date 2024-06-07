package et.telebof.types;

import java.io.Serializable;
import java.util.List;

public class Game extends JsonSerializable implements Serializable {
    public String title, description;
    public List<PhotoSize> photo;
    public String text;
    public List<MessageEntity> text_entities;
    public Animation animation;

}
