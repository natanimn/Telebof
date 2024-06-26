package et.telebof.requests;

import et.telebof.BotLog;
import et.telebof.Util;
import et.telebof.types.InputMedia;
import et.telebof.types.Markup;
import et.telebof.types.Message;

import java.util.List;


public class SendMediaGroup extends DefaultParameters<SendMediaGroup, List<Message>> {

    public <T extends InputMedia> SendMediaGroup(Object chatId, T[] medias, RequestSender requestSender) {
        super(chatId, requestSender, "sendMediaGroup");
        add("media", medias);
        for (InputMedia im: medias){
            if (im.isFile()){
                add(im.getInputFile().file.getName(), im.getInputFile().file);
                setContentType(im.getInputFile().contentType);
                setHasMultipart(true);
            }
        }

    }

    @Override
    @Deprecated
    public SendMediaGroup replyMarkup(Markup replyMarkup) {
        BotLog.warn("`sendMediaGroup` method does not support replyMarkup option.");
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Message> exec() {
        Object result = requestSender.makeRequest(this);
        List<Object> objects = Util.parse(result, List.class);
        return Util.parseList(objects, Message.class);
    }
}
