package et.telebof.errors;

import et.telebof.ApiResponse;
import et.telebof.TelegramApiException;

public class BadRequest extends TelegramApiException {
    public BadRequest(ApiResponse response){
        super("BadRequest", 400, response);
    }
}
