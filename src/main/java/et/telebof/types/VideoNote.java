package et.telebof.types;

import java.io.Serializable;

public class VideoNote implements Serializable {
    public String file_id, file_unique_id;
    public Integer length, duration;
    public Integer file_size;
    public PhotoSize thumbnail;

}