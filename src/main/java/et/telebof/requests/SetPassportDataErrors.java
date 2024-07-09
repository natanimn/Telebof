package et.telebof.requests;

import et.telebof.types.PassportElementError;

public class SetPassportDataErrors extends AbstractBaseRequest<SetPassportDataErrors, Boolean> {
    public SetPassportDataErrors(long userId, PassportElementError[] errors, RequestSender requestSender) {
        super(requestSender, "setPassportDataErrors");
        add("user_id", userId);
        add("errors", errors);
    }

}
