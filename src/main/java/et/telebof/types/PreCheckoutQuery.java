package et.telebof.types;

import java.io.Serializable;

public class PreCheckoutQuery implements Serializable {
    private String id;
    private User from;
    private String currency;
    private Integer total_amount;
    private String invoice_payload, shipping_option_id;
    private OrderInfo order_info;

    public String getId() {
        return id;
    }

    public User getFrom() {
        return from;
    }

    public String getCurrency() {
        return currency;
    }

    public Integer getTotalAmount() {
        return total_amount;
    }

    public String getInvoicePayload() {
        return invoice_payload;
    }

    public String getShippingOptionId() {
        return shipping_option_id;
    }

    public OrderInfo getOrderInfo() {
        return order_info;
    }
}
