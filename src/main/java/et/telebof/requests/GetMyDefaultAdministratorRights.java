package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.ChatAdministratorRights;

public class GetMyDefaultAdministratorRights extends AbstractBaseRequest<GetMyDefaultAdministratorRights, ChatAdministratorRights> {
    public GetMyDefaultAdministratorRights(RequestSender requestSender) {
        super(requestSender, "getMyDefaultAdministratorRights");
    }

    public GetMyDefaultAdministratorRights forChannel(boolean forChannel) {
        return add("for_channel", forChannel);
    }

    @Override
    public ChatAdministratorRights exec() {
        return Util.parse(requestSender.makeRequest(this), ChatAdministratorRights.class);
    }
}
