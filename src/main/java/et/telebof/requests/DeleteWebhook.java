package et.telebof.requests;

public class DeleteWebhook extends AbstractBaseRequest<DeleteWebhook, Boolean>{
    public DeleteWebhook(RequestSender requestSender){
        super(requestSender, "deleteWebhook");
    }

    public DeleteWebhook dropPendingUpdates(boolean dropPendingUpdates){
        return add("drop_pending_updates", dropPendingUpdates);
    }

}
