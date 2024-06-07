package et.telebof.types;

import java.io.Serializable;

public class ChatInviteLink extends JsonSerializable implements Serializable {
    public String invite_link, name;
    public User creator;
    public Integer expire_date, member_limit, pending_join_request_count;
    public Boolean is_primary, is_revoked, creates_join_request;

}
