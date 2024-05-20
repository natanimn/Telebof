package et.telebof.types;

import java.io.Serializable;

public class ChatShared extends JsonSerializable implements Serializable {
    public Integer request_id;
    public Long chat_id;

    public Integer getRequestId() {
        return request_id;
    }

    public Long getChatId() {
        return chat_id;
    }
}
