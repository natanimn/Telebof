package et.telebof.types;

import java.io.Serializable;

public class File extends JsonSerializable implements Serializable {
    public String file_id, file_unique_id, file_path;
    public Integer file_size;

}
