package et.telebof.types;

import et.telebof.BotLog;
import et.telebof.errors.TelegramError;

import java.io.Serializable;

public class InlineQueryResultCachedDocument extends InlineQueryMediaResult<InlineQueryResultCachedDocument> implements Serializable {
    private String document_file_id, description;
    public InlineQueryResultCachedDocument(String id, String document_file_id) {
        super("document", id);
        this.document_file_id = document_file_id;
    }

    public InlineQueryResultCachedDocument description(String description) {
        this.description = description;
        return this;
    }
}
