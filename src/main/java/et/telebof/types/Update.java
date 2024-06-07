package et.telebof.types;
import java.io.Serializable;

/** This class represents an incoming updates.
 * At most one of the optional parameters can be present in any given update.
 *
 * @see <a href="https://core.telegram.org/bots/api#Update">Telegram documentation</a>"
 * @author Natanim Negash
 * @version 1.2.0
 */

public class Update extends JsonSerializable implements Serializable {
    public int update_id;
    public Message message, edited_message, channel_post, edited_channel_post;
    public CallbackQuery callback_query;
    public InlineQuery inline_query;
    public ChosenInlineResult chosen_inline_result;
    public Poll poll;
    public PollAnswer poll_answer;
    public PreCheckoutQuery pre_checkout_query;
    public ShippingQuery shipping_query;
    public ChatMemberUpdated my_chat_member, chat_member;
    public ChatJoinRequest chat_join_request;

}
