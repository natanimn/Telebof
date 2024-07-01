package et.telebof.types;

import java.io.Serializable;

public class ChatMemberAdministrator extends ChatMember implements Serializable {
    public String status = "administrator";
    public Boolean can_post_stories, can_edit_stories, can_delete_stories;
}
