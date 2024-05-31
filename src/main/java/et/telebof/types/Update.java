package et.telebof.types;
import java.io.Serializable;

/** This class represents an incoming updates.
 * At most one of the optional parameters can be present in any given update.
 *
 * @see <a href="https://core.telegram.org/bots/api#Update">Telegram documentation</a>"
 * @author Natanim Negash
 * @version 1.1.0
 */

public class Update extends JsonSerializable implements Serializable {
    private int update_id;
    private Message message, edited_message, channel_post, edited_channel_post;
    private CallbackQuery callback_query;
    private InlineQuery inline_query;
    private ChosenInlineResult chosen_inline_result;
    private Poll poll;
    private PollAnswer poll_answer;
    private PreCheckoutQuery pre_checkout_query;
    private ShippingQuery shipping_query;
    private ChatMemberUpdated my_chat_member, chat_member;
    private ChatJoinRequest chat_join_request;

    public int getUpdateId() {
        return update_id;
    }

    public Message getMessage() {
        return message;
    }

    public Message getEditedMessage() {
        return edited_message;
    }

    public Message getChannelPost() {
        return channel_post;
    }

    public Message getEditedChannelPost() {
        return edited_channel_post;
    }

    public CallbackQuery getCallbackQuery() {
        return callback_query;
    }

    public InlineQuery getInlineQuery() {
        return inline_query;
    }

    public ChosenInlineResult getChosenInlineResult() {
        return chosen_inline_result;
    }

    public Poll getPoll() {
        return poll;
    }

    public PollAnswer getPollAnswer() {
        return poll_answer;
    }

    public PreCheckoutQuery getPreCheckoutQuery() {
        return pre_checkout_query;
    }

    public ShippingQuery getShippingQuery() {
        return shipping_query;
    }

    public ChatMemberUpdated getMyChatMember() {
        return my_chat_member;
    }

    public ChatMemberUpdated getChatMember() {
        return chat_member;
    }

    public ChatJoinRequest getChatJoinRequest() {
        return chat_join_request;
    }
}
