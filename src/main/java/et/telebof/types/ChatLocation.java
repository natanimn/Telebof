package et.telebof.types;


import java.io.Serializable;

public class ChatLocation implements Serializable {
    private Location location;
    private String address;

    public Location getLocation() {
        return location;
    }

    public String getAddress() {
        return address;
    }
}
