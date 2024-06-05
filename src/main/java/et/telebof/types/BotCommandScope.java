package et.telebof.types;

import java.io.Serializable;


abstract public class BotCommandScope implements Serializable  {
    protected String type;
    public BotCommandScope(String type) {
        this.type = type;
    }
}
