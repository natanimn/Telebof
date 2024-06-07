package et.telebof.types;


import java.io.Serializable;

public class Document implements Serializable {
    public String file_id, file_unique_id, file_name, mime_type;
    public Integer file_size;
    public PhotoSize thumbnail;
}
