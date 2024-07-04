package et.telebof.types;

import java.io.Serializable;
import java.util.List;

public class BusinessMessagesDeleted implements Serializable {
    public String business_connection_id;
    public Chat chat;
    public List<Integer> message_ids;
}
