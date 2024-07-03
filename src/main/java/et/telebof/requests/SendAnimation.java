package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.Message;
import et.telebof.types.MessageEntity;
import java.io.File;


public class SendAnimation extends DefaultParameters<SendAnimation, Message> {

    public SendAnimation(Object chatId, String animation, RequestSender requestSender) {
        super(chatId, requestSender, "sendAnimation");
        add("animation", animation);

    }

    public SendAnimation(Object chatId, File animation, RequestSender requestSender) {
        super(chatId, requestSender, "sendAnimation");
        add("animation", animation);
        setContentType(MediaContentType.GIF);
    }

    public SendAnimation caption(String cap) {
        return add("caption", cap);
    }

    public SendAnimation captionEntities(MessageEntity[] captionEntities) {
        return add("caption_entities", captionEntities);
    }

    public SendAnimation hasSpoiler(boolean hasSpoiler) {
        return add("has_spoiler", hasSpoiler);
    }
    
    public SendAnimation thumbnail(String thumbnail) { 
        return add("thumbnail", thumbnail);
    }
    
    public SendAnimation thumbnail(File thumbnail){
        setContentType(MediaContentType.PHOTO);
        return add("thumbnail", thumbnail);
    }
    public SendAnimation width(int width) {
        return add("width", width);
    }
    
    public SendAnimation height(int  height) {
        return add("height", height);
    }
    
    public SendAnimation duration(int  duration) {
        return add("duration", duration);
    }

    @Override
    public Message exec() {
        return Util.parse(requestSender.makeRequest(this), Message.class);
    }
}
