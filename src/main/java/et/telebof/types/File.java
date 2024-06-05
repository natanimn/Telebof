package et.telebof.types;

import java.io.Serializable;

public class File extends JsonSerializable implements Serializable {
    private String file_id, file_unique_id, file_path;
    private Integer file_size;

    public Integer getFileSize() {
        return file_size;
    }

    public String getFileId() {
        return file_id;
    }

    public String getFileUniqueId() {
        return file_unique_id;
    }

    public String getFilePath() {
        return file_path;
    }

}
