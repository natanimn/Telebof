package et.telebof;

import et.telebof.types.JsonSerializable;

import java.util.Map;

public class ApiResponse extends JsonSerializable {
    private boolean ok;
    private String description;
    private int error_code;
    private Object result;
    private Map<String,  Object> parameters;

    public boolean isOk() {
        return ok;
    }

    public String getDescription() {
        return description;
    }

    public int getErrorCode() {
        return error_code;
    }

    public Object getResult() {
        return result;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }
}

