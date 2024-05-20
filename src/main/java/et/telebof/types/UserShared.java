package et.telebof.types;

import java.io.Serializable;

public class UserShared implements Serializable {
    private Integer request_id;
    private Long userId;

    public Integer getRequestId() {
        return request_id;
    }

    public Long getUserId() {
        return userId;
    }
}
