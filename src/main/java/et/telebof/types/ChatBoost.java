package et.telebof.types;

import java.io.Serializable;

public class ChatBoost implements Serializable {
    public String boost_id;
    public Integer add_date;
    public Integer expiration_data;
    public ChatBoostSource source;
}
