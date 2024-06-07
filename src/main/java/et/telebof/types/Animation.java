package et.telebof.types;

import java.io.Serializable;

public class Animation implements Serializable {
    public String file_id, file_unique_id, file_name, mime_type;
    public Integer width, height, duration;
    public Integer file_size;
    public PhotoSize thumbnail;

}

