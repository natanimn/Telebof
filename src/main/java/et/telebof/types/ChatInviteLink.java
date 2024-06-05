package et.telebof.types;

import java.io.Serializable;

public class ChatInviteLink extends JsonSerializable implements Serializable {
    private String invite_link, name;
    private User creator;
    private Integer expire_date, member_limit, pending_join_request_count;
    private Boolean is_primary, is_revoked, creates_join_request;

    public String getInviteLink() {
        return invite_link;
    }

    public Boolean getCreatesJoinRequest() {
        return creates_join_request;
    }

    public Boolean getPrimary() {
        return is_primary;
    }

    public Boolean getIsRevoked() {
        return is_revoked;
    }

    public Integer getExpireDate() {
        return expire_date;
    }

    public Integer getMemberLimit() {
        return member_limit;
    }

    public Integer getPendingJoinRequestCount() {
        return pending_join_request_count;
    }

    public String getName() {
        return name;
    }

    public User getCreator() {
        return creator;
    }
}
