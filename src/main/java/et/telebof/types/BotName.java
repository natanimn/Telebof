package et.telebof.types;

import java.util.Objects;

public class BotName {
    public String name;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        BotName botName = (BotName) object;
        return Objects.equals(name, botName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
