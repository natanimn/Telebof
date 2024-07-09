package et.telebof.types;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class VideoChatParticipantsInvited implements Serializable {
    public List<User> users;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        VideoChatParticipantsInvited that = (VideoChatParticipantsInvited) object;
        return Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }
}
