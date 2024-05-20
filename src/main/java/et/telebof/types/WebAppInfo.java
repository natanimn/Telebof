package et.telebof.types;

import java.io.Serializable;


public class WebAppInfo implements Serializable {
    private String url;

    public WebAppInfo(String url) {
        this.url = url;
    }

    public WebAppInfo url(String url) {
        this.url = url;
        return this;
    }

    public String getUrl() {
        return url;
    }
}
