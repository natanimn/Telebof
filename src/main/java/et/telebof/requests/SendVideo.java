package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.Message;
import et.telebof.types.MessageEntity;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SendVideo extends DefaultParameters<SendVideo, Message> {
    public SendVideo(Object chatId, String video, RequestSender requestSender) {
        super(chatId, requestSender, "sendVideo");
        add("video", video);
    }

    public SendVideo(Object chatId, File video, RequestSender requestSender) {
        super(chatId, requestSender, "sendVideo");
        add("video", video);
        setContentType(MediaContentType.VIDEO);
    }

    public SendVideo caption(String cap) {
        return add("caption", cap);
    }

    public SendVideo captionEntities(MessageEntity[] captionEntities) {
        return add("caption_entities", List.of(captionEntities));
    }

    public SendVideo hasSpoiler(boolean hasSpoiler) {
        return add("has_spoiler", hasSpoiler);
    }

    public SendVideo supportsStreaming(boolean supportsStreaming) {
        return add("supports_streaming", supportsStreaming);
    }

    public SendVideo thumbnail(String thumbnail) {
        return add("thumbnail", thumbnail);
    }

    public SendVideo width(int width) {
        return add("width", width);
    }

    public SendVideo height(int height) {
        return add("height", height);
    }

    public SendVideo duration(Long duration) {
        return add("duration", duration);
    }

    @Override
    public Message exec() {
        return Util.parse(requestSender.makeRequest(this), Message.class);
    }

}
