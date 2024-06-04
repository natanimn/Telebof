package et.telebof.types;

import et.telebof.BotLog;
import et.telebof.errors.TelegramError;

import java.io.Serializable;

public class InlineQueryResultCachedDocument extends InlineQueryMediaResult<InlineQueryResultCachedDocument> implements Serializable {
    private String document_file_id, description;
    public InlineQueryResultCachedDocument(String id) {
        super("document", id);
    }

    public InlineQueryResultCachedDocument documentFileId(String documentFileId) {
        this.document_file_id = documentFileId;
        return this;
    }

    public InlineQueryResultCachedDocument description(String description) {
        this.description = description;
        return this;
    }

    @Override
    @Deprecated(forRemoval = true)
    public InlineQueryResultCachedDocument thumbnailUrl(String thumbnailUrl) {
        BotLog.warn("type InlineQueryResultCachedDocument does not support thumbnailUrl option");
        return this;
    }

}
