package et.telebof.types;

import java.io.Serializable;

public class User extends JsonSerializable implements Serializable {
    public Long id;
    public Boolean is_bot, is_premium, added_to_attachment_menu, can_join_groups,
            can_read_all_group_messages, supports_inline_queries, can_connect_to_business;
    public String first_name, last_name, language_code, username;

    public String mention(){
        // Do not forget to set parseMode to ParseMode.HTML
        String name = first_name + (last_name != null ? last_name : "");
        return String.format("<a href='tg://user?id=%d'>%s</a>", id, name);
    }

}


