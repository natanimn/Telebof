package et.telebof.types;

import java.io.Serializable;

public class SuccessfulPayment implements Serializable {
    public String currency;
    public Integer total_amount;
    public String invoice_payload, shipping_option_id;
    public OrderInfo order_info;
    public String telegram_payment_charge_id, provider_payment_charge_id;

}
