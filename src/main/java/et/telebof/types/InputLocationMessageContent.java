package et.telebof.types;

import java.util.HashMap;
import java.util.Map;

public class InputLocationMessageContent {
    private final Map<String, Object> json = new HashMap<>();
    public InputLocationMessageContent latitude(float latitude) {
        json.put("latitude", latitude);
        return this;
    }

    public InputLocationMessageContent longitude(float longitude) {
        json.put("longitude", longitude);
        return this;
    }

    public InputLocationMessageContent horizontalAccuracy(float horizontalAccuracy) {
        json.put("horizontal_accuracy", horizontalAccuracy);
        return this;
    }

    public InputLocationMessageContent livePeriod(int livePeriod) {
        json.put("live_period", livePeriod);
        return this;
    }

    public InputLocationMessageContent heading(int heading) {
        json.put("heading", heading);
        return this;
    }

    public InputLocationMessageContent proximityAlertRadius(int proximityAlertRadius) {
        json.put("proximity_alert_radius", proximityAlertRadius);
        return this;
    }

    public Map<String, Object> getJson() {
        return json;
    }
}
