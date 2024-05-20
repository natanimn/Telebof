package et.telebof.requests;

import et.telebof.BotLog;
import et.telebof.Parser;
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
                add(im.getInputFile().getFile().getName(), im.getInputFile().getFile());
                setContentType(im.getInputFile().getContentType());
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
    public List<Message> bind() {
        Object result = requestSender.makeRequest(this);
        List<Object> objects = Parser.parse(result, List.class);
        return Parser.parseList(objects, Message.class);
    }
}
