package et.telebof.types;

import java.io.Serializable;
import java.util.List;

public class ShippingOption implements Serializable {
    private String id, title;
    private List<LabeledPrice> prices;

    public ShippingOption(String id, String title, List<LabeledPrice> prices){
        this.id = id;
        this.title = title;
        this.prices = prices;
    }

}
