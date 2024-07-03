package et.telebof.types;

import java.io.Serializable;
import java.util.List;

public class TextQuote implements Serializable {
    public String text;
    public List<MessageEntity> entities;
    public Integer position;
    public Boolean is_manual;
}
