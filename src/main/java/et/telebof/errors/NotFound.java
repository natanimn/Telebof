package et.telebof.errors;

import et.telebof.ApiResponse;
import et.telebof.TelegramApiException;

public class NotFound extends TelegramApiException {
    public NotFound(ApiResponse response){
        super("NotFound", 404, response);
    }
}
