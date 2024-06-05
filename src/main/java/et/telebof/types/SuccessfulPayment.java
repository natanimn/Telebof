package et.telebof.types;

import java.io.Serializable;

public class SuccessfulPayment implements Serializable {
    private String currency;
    private Integer total_amount;
    private String invoice_payload, shipping_option_id;
    private OrderInfo order_info;
    private String telegram_payment_charge_id, provider_payment_charge_id;

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

    public String getTelegramPaymentChargeId() {
        return telegram_payment_charge_id;
    }

    public String getProviderPaymentChargeId() {
        return provider_payment_charge_id;
    }
}
