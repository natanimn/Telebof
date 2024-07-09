package et.telebof.types;

import java.util.Objects;

public class ChatBackground {
    public BackgroundType type;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ChatBackground that = (ChatBackground) object;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
