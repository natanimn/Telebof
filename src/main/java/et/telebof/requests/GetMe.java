package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.User;

public class GetMe extends AbstractBaseRequest<GetMe, User> {
    public GetMe(RequestSender requestSender) {
        super(requestSender, "getMe");
    }

    @Override
    public User bind() {
        return Util.parse(requestSender.makeRequest(this), User.class);
    }
}
