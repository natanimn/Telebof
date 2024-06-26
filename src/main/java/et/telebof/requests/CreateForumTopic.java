package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.ForumTopic;

public class CreateForumTopic extends AbstractBaseRequest<CreateForumTopic, ForumTopic> {
    public CreateForumTopic(Object chatId, String name, RequestSender requestSender) {
        super(chatId, requestSender, "createForumTopic");
        add("name", name);
    }

    public CreateForumTopic iconColor(int iconColor) {
        return add("icon_color", iconColor);
    }

    public CreateForumTopic iconCustomEmojiId(String iconCustomEmojiId) {
        return add("icon_custom_emoji_id", iconCustomEmojiId);
    }

    @Override
    public ForumTopic exec() {
        return Util.parse(requestSender.makeRequest(this), ForumTopic.class);
    }
}
