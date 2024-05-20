package et.telebof.types;

import java.io.Serializable;

public class Animation implements Serializable {
    private String file_id, file_unique_id, file_name, mime_type;
    private Integer width, height, duration;
    private Integer file_size;
    private PhotoSize thumbnail;

    public String getFileId() {
        return file_id;
    }

    public Integer getDuration() {
        return duration;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public String getFileName() {
        return file_name;
    }

    public Integer getFileSize() {
        return file_size;
    }

    public String getMimeType() {
        return mime_type;
    }

    public String getFileUniqueId() {
        return file_unique_id;
    }
}

