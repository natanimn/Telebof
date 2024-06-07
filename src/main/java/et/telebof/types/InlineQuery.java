package et.telebof.types;

public class InlineQuery extends JsonSerializable {
    public String id;
    public User from;
    public String query, offset, chat_type;
    public Location location;

}
