package et.telebof.types;

import java.io.Serializable;
import java.util.List;

public class PollOption implements Serializable {
    public String text;
    public Integer voter_count;
    public List<MessageEntity> text_entities;

}
