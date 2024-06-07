package et.telebof.types;

import java.io.Serializable;

public class Voice extends JsonSerializable implements Serializable {
    public String file_id, file_unique_id, mime_type;
    public Integer duration;
    public Integer file_size;

}
