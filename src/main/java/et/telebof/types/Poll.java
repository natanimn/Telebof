package et.telebof.types;

import java.io.Serializable;
import java.util.List;

public class Poll extends JsonSerializable implements Serializable {
    private String id, question, type, explanation;
    private List<PollOption> options;
    private Integer total_voter_count, correct_option_id, open_period, close_date;
    private Boolean is_closed, is_anonymous, allows_multiple_answers;
    private List<MessageEntity> explanation_entities;

    public String getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getType() {
        return type;
    }

    public String getExplanation() {
        return explanation;
    }

    public List<PollOption> getOptions() {
        return options;
    }

    public Integer getTotalVoterCount() {
        return total_voter_count;
    }

    public Integer getCorrectOptionId() {
        return correct_option_id;
    }

    public Integer getOpenPeriod() {
        return open_period;
    }

    public Integer getCloseDate() {
        return close_date;
    }

    public Boolean getIsClosed() {
        return is_closed;
    }

    public Boolean getIsAnonymous() {
        return is_anonymous;
    }

    public Boolean getAllowsMultipleAnswers() {
        return allows_multiple_answers;
    }

    public List<MessageEntity> getExplanationEntities() {
        return explanation_entities;
    }
}
