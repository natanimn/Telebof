package et.telebof.types;

import java.io.Serializable;

public  class VideoNote implements Serializable {
    private String file_id, file_unique_id;
    private Integer length, duration;
    private Integer file_size;
    private PhotoSize thumbnail;

    public String getFileId() {
        return file_id;
    }

    public String getFileUniqueId() {
        return file_unique_id;
    }

    public Integer getLength() {
        return length;
    }

    public Integer getDuration() {
        return duration;
    }

    public Integer getFileSize() {
        return file_size;
    }

    public PhotoSize getThumbnail() {
        return thumbnail;
    }
}