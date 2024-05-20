package et.telebof.types;


import java.io.Serializable;
import java.util.List;

public class WebhookInfo extends JsonSerializable implements Serializable {
    public String url, ip_address, last_error_message;
    public Integer pending_update_count, last_synchronization_error_date, max_connections;
    public Boolean has_custom_certificate;
    public List<String> allowed_updates;

    public String getUrl() {
        return url;
    }

    public String getIpAddress() {
        return ip_address;
    }

    public String getLastErrorMessage() {
        return last_error_message;
    }

    public Integer getPendingUpdateCount() {
        return pending_update_count;
    }

    public Integer getLastSynchronizationErrorDate() {
        return last_synchronization_error_date;
    }

    public Integer getMaxConnections() {
        return max_connections;
    }

    public Boolean getHasCustomCertificate() {
        return has_custom_certificate;
    }

    public List<String> getAllowedUpdates() {
        return allowed_updates;
    }
}

