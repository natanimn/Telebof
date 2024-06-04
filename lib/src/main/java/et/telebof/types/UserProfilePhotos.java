package et.telebof.types;

import java.io.Serializable;
import java.util.List;

public class UserProfilePhotos implements Serializable {
    private Integer total_count;
    private List<PhotoSize> photos;

    public List<PhotoSize> getPhotos() {
        return photos;
    }

    public Integer getTotalCount() {
        return total_count;
    }
}
