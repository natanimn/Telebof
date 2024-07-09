package et.telebof.requests;


import java.util.List;

public class SetStickerKeywords extends AbstractBaseRequest<SetStickerKeywords, Boolean> {
    public SetStickerKeywords(String sticker, String[] keywords, RequestSender requestSender) {
        super(requestSender, "setStickerKeywords");
        add("sticker", sticker);
        add("keywords", List.of(keywords));
    }

}
