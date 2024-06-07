package et.telebof.types;

import java.io.Serializable;

public class ShippingQuery extends JsonSerializable implements Serializable {
    public String id;
    public User from;
    public String invoice_payload;
    public ShippingAddress shipping_address;

}
