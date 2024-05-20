package et.telebof;

import java.util.Map;

public class TelegramApiException extends RuntimeException {
    private boolean ok;
    private String description;
    private int error_code;
    private Map<String, Object> parameters;

    public TelegramApiException(ApiResponse response) {
        super(String.format("Error code: %d. %s", response.getErrorCode(), response.getDescription()));
        this.ok = response.isOk();
        this.description = response.getDescription();
        this.error_code = response.getErrorCode();
        this.parameters = response.getParameters();
    }

    public TelegramApiException(String errorType, int errorCode, ApiResponse response){
        super(String.format("%s: %d. %s", errorType, errorCode, response.getDescription()));
        this.ok = response.isOk();
        this.description = response.getDescription();
        this.error_code = response.getErrorCode();
        this.parameters = response.getParameters();
    }

    public boolean isOk() {
        return ok;
    }

    public String getDescription() {
        return description;
    }

    public int getErrorCode() {
        return error_code;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

}