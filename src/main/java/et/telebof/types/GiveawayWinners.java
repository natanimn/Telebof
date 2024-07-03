package et.telebof.types;

import java.util.List;

public class GiveawayWinners {
    public Chat chat;
    public int giveaway_message_id;
    public int winners_selection_date;
    public int winner_count;
    public List<User> winners;
    public Integer additional_chat_count, premium_subscription_month_count, unclaimed_prize_count;
    public Boolean only_new_members, was_refunded;
    public String prize_description;
}
