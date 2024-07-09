package et.telebof.types;

import java.io.Serializable;
import java.util.Objects;

public class BusinessLocation implements Serializable {
    public String address;
    public Location location;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        BusinessLocation that = (BusinessLocation) object;
        return Objects.equals(address, that.address) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, location);
    }
}
