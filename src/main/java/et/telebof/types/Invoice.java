package et.telebof.types;

import java.io.Serializable;

public class Invoice implements Serializable {
    public String title, description, start_parameter, currency;
    public Integer total_amount;

}
