package et.telebof.requests;

import et.telebof.types.ChatAdministratorRights;

public class SetMyDefaultAdministratorRights extends AbstractBaseRequest<SetMyDefaultAdministratorRights, Boolean> {

    public SetMyDefaultAdministratorRights(RequestSender requestSender) {
        super(requestSender, "srtMyDefaultAdministratorRights");
    }

    public SetMyDefaultAdministratorRights rights(ChatAdministratorRights rights) {
        return add("rights", rights);
    }

    public SetMyDefaultAdministratorRights forChannel(boolean forChannel) {
        return add("for_channel", forChannel);
    }

}
