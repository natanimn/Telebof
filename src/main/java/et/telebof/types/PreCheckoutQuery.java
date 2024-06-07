package et.telebof.types;

import java.io.Serializable;

public class PreCheckoutQuery implements Serializable {
    public String id;
    public User from;
    public String currency;
    public Integer total_amount;
    public String invoice_payload, shipping_option_id;
    public OrderInfo order_info;

}
