package et.telebof.types;

import java.io.Serializable;
import java.util.List;

public class UsersShared implements Serializable {
    public int request_id;
    public List<SharedUser> users;
}
