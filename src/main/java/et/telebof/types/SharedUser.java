package et.telebof.types;

import java.io.Serializable;
import java.util.List;

public class SharedUser implements Serializable {
    public Long user_id;
    public String first_name, last_name, username;
    public List<PhotoSize> photo;
}
