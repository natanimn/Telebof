package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.Markup;
import et.telebof.types.Message;
import et.telebof.types.ReplyParameters;

public class SendLocation extends AbstractBaseRequest<SendLocation, Message> {
    public SendLocation(Object chatId, float latitude, float longitude, RequestSender requestSender) {
        super(chatId, requestSender, "sendLocation");
        add("longitude", longitude);
        add("latitude", latitude);
    }

    public SendLocation horizontalAccuracy(float horizontalAccuracy) {
        return add("horizontal_accuracy", horizontalAccuracy);
    }

    public SendLocation livePeriod(int livePeriod){
        return add("live_period", livePeriod);
    }

    public SendLocation heading(int heading){
        return add("heading", heading);
    }

    public SendLocation proximityAlertRadius(int proximityAlertRadius){
        return add("proximity_alert_radius", proximityAlertRadius);
    }

    public SendLocation disableNotification(boolean disableNotification) {
        return add("disable_notification", disableNotification);
    }

    public SendLocation protectContent(boolean protectContent) {
        return add("protect_content", protectContent);
    }

    @Deprecated(since = "v1.5.0")
    public SendLocation replyToMessageId(int replyToMessageId) {
        return add("reply_to_message_id", replyToMessageId);
    }

    @Deprecated(since = "v1.5.0")
    public SendLocation  allowSendingWithoutReply(boolean allowSendingWithoutReply) {
        return add("allow_sending_without_reply", allowSendingWithoutReply);
    }

    public SendLocation replyParameters(ReplyParameters replyParameters){
        return add("reply_parameters", replyParameters);
    }


    public SendLocation replyMarkup(Markup replyMarkup) {
        return add("reply_markup", replyMarkup);
    }

    @Override
    public Message exec() {
        return Util.parse(requestSender.makeRequest(this), Message.class);
    }
}
