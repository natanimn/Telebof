package et.telebof.types;

import java.io.Serializable;

public class PassportFile  implements Serializable {
    public String getFileId() {
        return file_id;
    }

    public String getFileUniqueId() {
        return file_unique_id;
    }

    public Integer getFileSize() {
        return file_size;
    }

    public Integer getFileDate() {
        return file_date;
    }

    public String file_id, file_unique_id;
    public Integer file_size, file_date;
}
