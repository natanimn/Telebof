package et.telebof.types;

import java.io.Serializable;

public class InlineQueryResultDocument extends InlineQueryMediaResult<InlineQueryResultDocument> implements Serializable {
    private String document_url,  document, description, mime_type;
    private Integer thumbnail_width, thumbnail_height;

    public InlineQueryResultDocument(String id) {
        super("document", id);
    }

    public InlineQueryResultDocument documentUrl(String documentUrl) {
        this.document_url = documentUrl;
        return this;
    }

    public InlineQueryResultDocument thumbnailWidth(int thumbnailWidth) {
        this.thumbnail_width = thumbnailWidth;
        return this;
    }

    public InlineQueryResultDocument thumbnailHeight(int thumbnailHeight) {
        this.thumbnail_height = thumbnailHeight;
        return this;
    }

    public InlineQueryResultDocument description(String description) {
        this.description = description;
        return this;
    }

    public InlineQueryResultDocument mimeType(String mimeType) {
        this.mime_type = mimeType;
        return this;
    }
}
