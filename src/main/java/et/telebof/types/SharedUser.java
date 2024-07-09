package et.telebof.types;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class SharedUser implements Serializable {
    public Long user_id;
    public String first_name, last_name, username;
    public List<PhotoSize> photo;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        SharedUser that = (SharedUser) object;
        return Objects.equals(user_id, that.user_id) && Objects.equals(first_name, that.first_name) &&
                Objects.equals(last_name, that.last_name) && Objects.equals(username, that.username) &&
                Objects.equals(photo, that.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, first_name, last_name, username, photo);
    }
}
