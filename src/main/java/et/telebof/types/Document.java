package et.telebof.types;


import java.io.Serializable;

public class Document implements Serializable {
    private String file_id, file_unique_id, file_name, mime_type;
    private Integer file_size;
    private PhotoSize thumbnail;

    public PhotoSize getThumbnail() {
        return thumbnail;
    }

    public Integer getFileSize() {
        return file_size;
    }

    public String getFileName() {
        return file_name;
    }

    public String getFileUniqueId() {
        return file_unique_id;
    }

    public String getFileId() {
        return file_id;
    }

    public String getMimeType() {
        return mime_type;
    }
}
