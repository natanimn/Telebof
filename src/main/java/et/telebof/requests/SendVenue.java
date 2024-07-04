package et.telebof.requests;
import et.telebof.Util;
import et.telebof.types.Message;
import et.telebof.types.ReplyParameters;

public class SendVenue extends AbstractBaseRequest<SendVenue, Message> {

    public SendVenue(Object chatId, float latitude, float longitude, String title, String address, RequestSender requestSender) {
        super(chatId, requestSender, "sendVenue");
        add("latitude", latitude);
        add("longitude", longitude);
        add("title", title);
        add("address", address);
    }

    public SendVenue foursquareId(String foursquareId){
        return add("foursquare_id", foursquareId);
    }

    public SendVenue foursquareType(String foursquareType){
        return add("foursquare_type", foursquareType);
    }

    public SendVenue googlePlaceId(String googlePlaceId){
        return add("google_place_id", googlePlaceId);
    }

    public SendVenue googlePlaceType(String googlePlaceType){
        return add("google_place_type", googlePlaceType);
    }

    public SendVenue disableNotification(boolean disableNotification) {
        return add("disable_notification", disableNotification);
    }

    public SendVenue protectContent(boolean protectContent) {
        return add("protect_content", protectContent);
    }

    @Deprecated(since = "v1.5.0")
    public SendVenue replyToMessageId(int replyToMessageId) {
        return add("reply_to_message_id", replyToMessageId);
    }

    @Deprecated(since = "v1.5.0")
    public SendVenue  allowSendingWithoutReply(boolean allowSendingWithoutReply) {
        return add("allow_sending_without_reply", allowSendingWithoutReply);
    }

    public SendVenue replyParameters(ReplyParameters parameters){
        return add("reply_parameters", parameters);
    }

    public SendVenue businessConnectionId(String business_connection_id){
        return add("business_connection_id", business_connection_id);
    }
    @Override
    public Message exec() {
        return Util.parse(requestSender.makeRequest(this), Message.class);
    }
}
