package et.telebof.requests;

public class Close extends AbstractBaseRequest<Close, Boolean> {
    public Close(RequestSender requestSender){
        super(requestSender, "close");
    }

    @Override
    public Boolean exec() {
        Object response = requestSender.makeRequest(this);
        return (Boolean) response;
    }
}
