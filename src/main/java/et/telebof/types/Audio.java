package et.telebof.types;

import java.io.Serializable;

public class Audio implements Serializable {
    public String file_id, file_unique_id, performer, title, file_name, mime_type;
    public Integer duration;
    public Integer file_size;
    public PhotoSize thumbnail;

}
