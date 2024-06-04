package et.telebof.requests;

import et.telebof.types.ChatPermission;

public class UnRestrictChatMember extends RestrictChatMember {
    public UnRestrictChatMember(Object chatId, long userId, ChatPermission permissions, RequestSender requestSender) {
        super(chatId, userId, permissions, requestSender);
        parameters.put("can_send_messages", true);
        parameters.put("can_send_audios", true);
        parameters.put("can_send_documents", true);
        parameters.put("can_send_photos", true);
        parameters.put("can_send_videos", true);
        parameters.put("can_send_video_notes", true);
        parameters.put("can_send_voice_notes", true);
        parameters.put("can_send_polls", true);
        parameters.put("can_send_other_messages", true);
        parameters.put("can_add_web_page_previews", true);
        parameters.put("can_invite_users", true);
    }
}
