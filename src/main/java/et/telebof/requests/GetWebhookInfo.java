package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.WebhookInfo;

public class GetWebhookInfo extends AbstractBaseRequest<GetWebhookInfo, WebhookInfo> {
    public GetWebhookInfo(RequestSender requestSender){
        super(requestSender, "getWebhookInfo");
    }

    @Override
    public WebhookInfo exec() {
        return Util.parse(requestSender.makeRequest(this), WebhookInfo.class);
    }
}
