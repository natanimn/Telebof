package et.telebof.types;

import java.io.Serializable;
import java.util.List;

public class VideoChatParticipantsInvited extends JsonSerializable implements Serializable {
    public List<User> users;

}
