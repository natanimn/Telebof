package et.telebof.requests;

public class LogOut extends AbstractBaseRequest<LogOut, Boolean> {
    public LogOut(RequestSender requestSender) {
        super(requestSender, "logOut");
    }

    @Override
    public Boolean exec() {
        return (Boolean) requestSender.makeRequest(this);
    }
}
