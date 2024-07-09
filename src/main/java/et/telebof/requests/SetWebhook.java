package et.telebof.requests;

import et.telebof.Webhook;

public class SetWebhook extends AbstractBaseRequest<SetWebhook, Boolean> {
    public SetWebhook(Webhook webhook, RequestSender requestSender){
        super(requestSender, "setWebhook");
        for (String key: webhook.getObjectMap().keySet()){
            add(key, webhook.getObjectMap().get(key));
        }
    }

}
