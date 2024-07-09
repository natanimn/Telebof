package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.Message;

public class SetMyDescription extends AbstractBaseRequest<SetMyDescription, Boolean>{

    public SetMyDescription(String description, String languageCode, RequestSender requestSender){
        super(requestSender, "setMyDescription");
        add("description", description);
        add("language_code", languageCode);
    }

}
