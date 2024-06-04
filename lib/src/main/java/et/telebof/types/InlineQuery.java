package et.telebof.types;

public class InlineQuery extends JsonSerializable {
    private String id;
    private User from;
    private String query, offset, chat_type;
    private Location location;

    public String getQuery() {
        return query;
    }

    public User getFrom() {
        return from;
    }

    public Location getLocation() {
        return location;
    }

    public String getId() {
        return id;
    }

    public String getChatType() {
        return chat_type;
    }

    public String getOffset() {
        return offset;
    }
}
