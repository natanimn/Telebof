package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.BotName;

public class GetMyName extends AbstractBaseRequest<GetMyName, BotName> {
    public GetMyName(RequestSender requestSender){
        super(requestSender, "getMyName", BotName.class);
    }

}
