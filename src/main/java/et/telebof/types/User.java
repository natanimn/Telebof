package et.telebof.types;

import java.io.Serializable;

public class User extends JsonSerializable implements Serializable {
    private Long id;
    private Boolean is_bot, is_premium, added_to_attachment_menu, can_join_groups,
            can_read_all_group_messages, supports_inline_queries;
    private String first_name, last_name, language_code;

    public Long getId() {
        return id;
    }

    public Boolean getIsBot() {
        return is_bot;
    }

    public Boolean getIsPremium() {
        return is_premium;
    }

    public Boolean getAddedToAttachmentMenu() {
        return added_to_attachment_menu;
    }

    public Boolean getCanJoinGroups() {
        return can_join_groups;
    }

    public Boolean getCanReadAllGroupMessages() {
        return can_read_all_group_messages;
    }

    public Boolean getSupportsInlineQueries() {
        return supports_inline_queries;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public String getLanguageCode() {
        return language_code;
    }


}


