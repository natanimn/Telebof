package et.telebof.types;

import java.io.Serializable;

public class Voice extends JsonSerializable implements Serializable {
    private String file_id, file_unique_id, mime_type;
    private Integer duration;
    private Integer file_size;

    public String getFileId() {
        return file_id;
    }

    public String getFileUniqueId() {
        return file_unique_id;
    }

    public String getMimeType() {
        return mime_type;
    }

    public Integer getDuration() {
        return duration;
    }

    public Integer getFileSize() {
        return file_size;
    }
}
