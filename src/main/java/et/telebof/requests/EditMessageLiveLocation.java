package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.InlineKeyboardMarkup;
import et.telebof.types.Message;

public class EditMessageLiveLocation extends AbstractBaseRequest<EditMessageLiveLocation, Message> {
    public EditMessageLiveLocation(Object chatId, float latitude, float longitude, int messageId, RequestSender requestSender) {
        super(chatId, requestSender, "editMessageLiveLocation");
       
        add("latitude", latitude);
        add("longitude", longitude);
        add("message_id", messageId);
    }

    public EditMessageLiveLocation(String inlineMessageId, float latitude, float longitude, RequestSender requestSender) {
        super(requestSender, "editMessageLiveLocation");
        add("latitude", latitude);
        add("longitude", longitude);
        add("inline_message_id", inlineMessageId);
    }

    public EditMessageLiveLocation inlineMessageId(String inlineMessageId){
        return add("inline_message_id", inlineMessageId);
    }

    public EditMessageLiveLocation horizontalAccuracy(float horizontalAccuracy){
        return add("horizontal_accuracy", horizontalAccuracy);
    }

    public EditMessageLiveLocation heading(int heading){
        return add("heading", heading);
    }

    public EditMessageLiveLocation proximityAlertRadius(int proximityAlertRadius){
        return add("proximity_alert_radius", proximityAlertRadius);
    }

    public EditMessageLiveLocation replyMarkup(InlineKeyboardMarkup markup) {
        return add("reply_markup", markup);
    }

    public EditMessageLiveLocation livePeriod(int live_period){
        return add("live_period", live_period);
    }

    @Override
    public Message exec() {
        return Util.parse(requestSender.makeRequest(this), Message.class);
    }
}
