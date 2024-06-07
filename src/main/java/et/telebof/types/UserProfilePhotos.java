package et.telebof.types;

import java.io.Serializable;
import java.util.List;

public class UserProfilePhotos implements Serializable {
    public Integer total_count;
    public List<PhotoSize> photos;

}
