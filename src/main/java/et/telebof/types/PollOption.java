package et.telebof.types;

import java.io.Serializable;

public class PollOption implements Serializable {
    private String text;
    private Integer voter_count;

    public String getText() {
        return text;
    }

    public Integer getVoterCount() {
        return voter_count;
    }
}
