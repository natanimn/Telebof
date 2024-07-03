package et.telebof.types;

import java.io.Serializable;
import java.util.List;

public class UsersShared implements Serializable {
    public int request_id;
    public List<User> users;

    public UsersShared(int request_id, List<User> users){
        this.request_id = request_id;
        this.users = users;
    }
}
