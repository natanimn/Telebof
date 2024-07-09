package et.telebof.requests;

import com.google.gson.reflect.TypeToken;
import et.telebof.Util;
import et.telebof.types.ChatMember;
import et.telebof.types.Sticker;

import java.lang.reflect.Type;
import java.util.List;

public class GetForumTopicIconStickers extends AbstractBaseRequest<GetForumTopicIconStickers, List<Sticker> > {
    private static final Type responseType = TypeToken.getParameterized(List.class, Sticker.class).getType();
    public GetForumTopicIconStickers(RequestSender requestSender) {
        super(requestSender, "getForumTopicIconStickers", responseType);
    }

}
