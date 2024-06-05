package et.telebof.requests;

public class Close extends AbstractBaseRequest<Close, Boolean> {
    public Close(RequestSender requestSender){
        super(requestSender, "close");
    }

    @Override
    public Boolean bind() {
        return (Boolean) requestSender.makeRequest(this);
    }
}
