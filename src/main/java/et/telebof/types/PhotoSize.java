package et.telebof.types;

import java.io.Serializable;

public  class PhotoSize implements Serializable {
    private String file_id, file_unique_id;
    private Integer width, height;
    private Integer file_size;

    public String getFileId() {
        return file_id;
    }

    public String getFileUniqueId() {
        return file_unique_id;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getFileSize() {
        return file_size;
    }
}
