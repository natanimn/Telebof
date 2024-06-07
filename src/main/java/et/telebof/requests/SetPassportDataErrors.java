package et.telebof.requests;
import et.telebof.types.PassportElementError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SetPassportDataErrors extends AbstractBaseRequest<SetPassportDataErrors, Boolean> {
    public SetPassportDataErrors(long userId, PassportElementError[] errors, RequestSender requestSender) {
        super(requestSender, "setPassportDataErrors");
        add("user_id", userId);
        add("errors", List.of(errors));
    }

    @Override
    public Boolean exec() {
        Object response = requestSender.makeRequest(this);
        return (Boolean) response;
    }
}
