package et.telebof.types;

import java.io.Serializable;
import java.util.List;

public class ChatShared extends JsonSerializable implements Serializable {
    public Integer request_id;
    public Long chat_id;
    public String title, username;
    public List<PhotoSize> photo;
}
