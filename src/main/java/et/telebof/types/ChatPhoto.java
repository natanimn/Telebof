package et.telebof.types;

import java.io.Serializable;

public class ChatPhoto implements Serializable {
    private String small_file_id, small_file_unique_id, big_file_id, big_file_unique_id;

    public String getBigFileId() {
        return big_file_id;
    }

    public String getBigFileUniqueId() {
        return big_file_unique_id;
    }

    public String getSmallFileId() {
        return small_file_id;
    }

    public String getSmallFileUniqueId() {
        return small_file_unique_id;
    }


}
