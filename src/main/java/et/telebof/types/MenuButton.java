package et.telebof.types;

import java.io.Serializable;


abstract public class MenuButton implements Serializable {
    private String type;

    public MenuButton(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
