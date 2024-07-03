package et.telebof.types;

import java.io.Serializable;


public class WebAppInfo implements Serializable {
    public String url;

    public WebAppInfo(String url) {
        this.url = url;
    }

}
