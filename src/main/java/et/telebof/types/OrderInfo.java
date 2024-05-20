package et.telebof.types;

import java.io.Serializable;

public class OrderInfo extends JsonSerializable implements Serializable {
    public String name, phoneNumber, email;
    public ShippingAddress shippingAddress;

}
