package et.telebof.types;

import java.io.Serializable;


public class LabeledPrice implements Serializable {
    private String label;
    private Integer amount;

    public LabeledPrice(String label, int amount){
        this.label = label;
        this.amount = amount;
    }
}
