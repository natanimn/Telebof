package et.telebof.types;

import java.io.Serializable;
import java.util.Objects;

public class Story implements Serializable {
    public Chat chat;
    public Integer id;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Story story = (Story) object;
        return Objects.equals(chat, story.chat) && Objects.equals(id, story.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chat, id);
    }
}
