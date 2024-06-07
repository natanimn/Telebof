package et.telebof.types;

import java.io.Serializable;


abstract public class MenuButton implements Serializable {
    public String type;

    public MenuButton(String type) {
        this.type = type;
    }

}
