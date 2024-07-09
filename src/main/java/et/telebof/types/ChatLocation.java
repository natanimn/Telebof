package et.telebof.types;


import java.io.Serializable;
import java.util.Objects;

public class ChatLocation implements Serializable {
    public Location location;
    public String address;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ChatLocation that = (ChatLocation) object;
        return Objects.equals(location, that.location) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, address);
    }
}
