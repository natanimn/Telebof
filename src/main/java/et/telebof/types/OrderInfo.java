package et.telebof.types;

import java.io.Serializable;

public class OrderInfo extends JsonSerializable implements Serializable {
    public String name, phone_number, email;
    public ShippingAddress shipping_address;

}
