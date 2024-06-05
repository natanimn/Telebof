package et.telebof.types;

import java.io.Serializable;

public class ShippingQuery extends JsonSerializable implements Serializable {
    private String id;
    private User from;
    private String invoice_payload;
    private ShippingAddress shipping_address;

    public String getId() {
        return id;
    }

    public User getFrom() {
        return from;
    }

    public String getInvoicePayload() {
        return invoice_payload;
    }

    public ShippingAddress getShippingAddress() {
        return shipping_address;
    }
}
