package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.BotDescription;

public class GetMyDescription extends AbstractBaseRequest<GetMyDescription, BotDescription> {
    public GetMyDescription(RequestSender requestSender) {
        super(requestSender, "getMyDescription");
    }

    @Override
    public BotDescription exec() {
        return Util.parse(requestSender.makeRequest(this), BotDescription.class);
    }
}
