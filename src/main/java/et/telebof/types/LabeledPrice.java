package et.telebof.types;

import java.io.Serializable;


public class LabeledPrice implements Serializable {
    private String label;
    private Integer amount;

    public LabeledPrice label(String label) {
        this.label = label;
        return this;
    }

    public LabeledPrice amount(int amount) {
        this.amount = amount;
        return this;
    }

}
