package et.telebof.types;

import java.io.Serializable;

public class MessageOrigin implements Serializable {
    public String type;
    public Integer date;
    public User sender_user;
    public String sender_user_name;
    public Chat sender_chat;
    public String author_signature;
    public Integer message_id;
}
