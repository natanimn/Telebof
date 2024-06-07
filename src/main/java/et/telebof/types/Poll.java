package et.telebof.types;

import java.io.Serializable;
import java.util.List;

public class Poll extends JsonSerializable implements Serializable {
    public String id, question, type, explanation;
    public List<PollOption> options;
    public Integer total_voter_count, correct_option_id, open_period, close_date;
    public Boolean is_closed, is_anonymous, allows_multiple_answers;
    public List<MessageEntity> explanation_entities;

}
