package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.BusinessConnection;

public class GetBusinessConnection extends AbstractBaseRequest<GetBusinessConnection, BusinessConnection> {
    public GetBusinessConnection(String business_connection_id, RequestSender requestSender){
        super(requestSender, "getBusinessConnection");
    }

    @Override
    public BusinessConnection exec() {
        return Util.parse(requestSender.makeRequest(this), BusinessConnection.class);
    }
}
