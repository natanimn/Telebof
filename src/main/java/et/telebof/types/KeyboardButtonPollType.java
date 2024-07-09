package et.telebof.types;

import et.telebof.enums.PollType;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Objects;

public class KeyboardButtonPollType implements Serializable {

    private String type;
    public KeyboardButtonPollType(@NotNull PollType type) {
        this.type = type.name().toLowerCase();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        KeyboardButtonPollType that = (KeyboardButtonPollType) object;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
