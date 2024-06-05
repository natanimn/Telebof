package et.telebof.types;

import java.io.Serializable;
import java.util.List;

public class VideoChatParticipantsInvited extends JsonSerializable implements Serializable {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }
}
