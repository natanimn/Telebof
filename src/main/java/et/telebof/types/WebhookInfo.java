package et.telebof.types;


import java.io.Serializable;
import java.util.List;

public class WebhookInfo extends JsonSerializable implements Serializable {
    public String url, ip_address, last_error_message;
    public Integer pending_update_count, last_synchronization_error_date, max_connections;
    public Boolean has_custom_certificate;
    public List<String> allowed_updates;

}

