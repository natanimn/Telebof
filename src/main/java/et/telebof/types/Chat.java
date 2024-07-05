package et.telebof.types;

import java.io.Serializable;
import java.util.List;

public class Chat extends JsonSerializable  implements Serializable {

    public long id;
    public String type, title, username, first_name, last_name;
    public Boolean is_forum;

}
