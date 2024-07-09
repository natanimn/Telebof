package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.BotDescription;

public class GetMyDescription extends AbstractBaseRequest<GetMyDescription, BotDescription> {
    public GetMyDescription(RequestSender requestSender) {
        super(requestSender, "getMyDescription", BotDescription.class);
    }

}
