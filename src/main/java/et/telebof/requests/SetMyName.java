package et.telebof.requests;

public class SetMyName extends AbstractBaseRequest<SetMyName, Boolean> {

    public SetMyName(RequestSender requestSender){
        super(requestSender, "setMyName");

    }

    public SetMyName name(String name){
        add("name", name);
        return this;
    }

    public SetMyName languageCode(String languageCode){
        add("language_code", languageCode);
        return this;
    }
}
