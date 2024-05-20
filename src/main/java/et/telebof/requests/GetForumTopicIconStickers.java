package et.telebof.requests;

import et.telebof.Parser;
import et.telebof.types.Sticker;

import java.util.List;

public class GetForumTopicIconStickers extends AbstractBaseRequest<GetForumTopicIconStickers, List<Sticker> > {

    public GetForumTopicIconStickers(RequestSender requestSender) {
        super(requestSender, "getForumTopicIconStickers");
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Sticker> bind() {
        return Parser.parseList(Parser.parse(requestSender.makeRequest(this), List.class), Sticker.class);
    }
}
