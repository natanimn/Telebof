package et.telebof.types;

import java.io.Serializable;

public class Audio implements Serializable {
    private String fileId, file_unique_id, performer, title, file_name, mime_type;
    private Integer duration;
    private Integer file_size;
    private PhotoSize thumbnail;


    public String getFileId() {
        return fileId;
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

    public String getFileUniqueId() {
        return file_unique_id;
    }

    public String getPerformer() {
        return performer;
    }

    public String getTitle() {
        return title;
    }

    public String getFileName() {
        return file_name;
    }

    public String getMimeType() {
        return mime_type;
    }

}
