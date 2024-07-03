package et.telebof.types;

import java.io.Serializable;
import java.util.List;

public class Giveaway implements Serializable {
    public List<Chat> chats;
    public int winners_selection_date;
    public int winner_count;
    public Boolean only_new_members, has_public_winners;
    public String prize_description;
    public List<String> country_codes;
    public Integer premium_subscription_month_count;

}
