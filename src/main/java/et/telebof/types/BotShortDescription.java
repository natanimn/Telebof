package et.telebof.types;

import java.util.Objects;

public class BotShortDescription {
    public String short_description;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        BotShortDescription that = (BotShortDescription) object;
        return Objects.equals(short_description, that.short_description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(short_description);
    }
}
