package et.telebof.types;

import java.io.Serializable;
import java.util.List;

public class ShippingOption implements Serializable {
    private String id, title;
    private List<LabeledPrice> prices;

    public ShippingOption id(String id) {
        this.id = id;
        return this;
    }

    public ShippingOption title(String title) {
        this.title = title;
        return this;
    }

    public ShippingOption prices(LabeledPrice[] prices) {
        this.prices = List.of(prices);
        return this;
    }

}
