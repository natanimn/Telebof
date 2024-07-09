package et.telebof.requests;

import et.telebof.types.WebhookInfo;

public class GetWebhookInfo extends AbstractBaseRequest<GetWebhookInfo, WebhookInfo> {
    public GetWebhookInfo(RequestSender requestSender){
        super(requestSender, "getWebhookInfo", WebhookInfo.class);
    }

}
