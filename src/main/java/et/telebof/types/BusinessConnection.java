package et.telebof.types;

import java.io.Serializable;

public class BusinessConnection implements Serializable{
    public String id;
    public User user;
    public Long user_Chat_id;
    public Integer date;
    public Boolean can_reply, is_enabled;
}