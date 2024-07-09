package et.telebof.types;

import java.io.Serializable;
import java.util.Objects;


public class WebAppInfo implements Serializable {
    public String url;

    public WebAppInfo(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        WebAppInfo that = (WebAppInfo) object;
        return Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }
}
