package et.telebof.types;

import java.io.Serializable;

public class Invoice implements Serializable {
    private String title, description, start_parameter, currency;
    private Integer total_amount;

    public String getDescription() {
        return description;
    }

    public Integer getTotalAmount() {
        return total_amount;
    }

    public String getTitle() {
        return title;
    }

    public String getCurrency() {
        return currency;
    }

    public String getStartParameter() {
        return start_parameter;
    }

}
