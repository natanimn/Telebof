package et.telebof.requests;

import et.telebof.BotLog;
import et.telebof.enums.ParseMode;
import et.telebof.types.Message;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class SendSticker extends DefaultParameters<SendSticker, Message> {

    public SendSticker(Object chatId, File sticker, RequestSender requestSender) {
        super(chatId, requestSender, "sendSticker");
        add("sticker", sticker);
    }

    public SendSticker(Object chatId, String sticker, RequestSender requestSender) {
        super(chatId, requestSender, "sendSticker");
        add("sticker", sticker);
    }

    public SendSticker emoji(String emoji) {
        return add("emoji", emoji);
    }

    @Override
    @Deprecated(forRemoval = true)
    public SendSticker parseMode(@NotNull ParseMode parseM) {
        BotLog.warn("`sendSticker` method does not support parseMode option.");
        return this;
    }

}
