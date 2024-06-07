package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.Update;
import et.telebof.enums.Updates;
import java.util.ArrayList;
import java.util.List;

public class GetUpdates extends AbstractBaseRequest<GetUpdates, List<Update>>{

    public GetUpdates(RequestSender requestSender){
        super(requestSender, "getUpdates");
    }

    public GetUpdates limit(Integer limit){
        add("limit", limit);
        return this;
    }

    public GetUpdates offset(Integer offset){
        add("offset", offset);
        return this;
    }

    public GetUpdates allowedUpdates(Updates[] allowedUpdates){
        List<String> updates = new ArrayList<>();
        if (allowedUpdates != null) {
            List.of(allowedUpdates).forEach(update -> updates.add(update.name().toLowerCase()));
        }
        add("allowed_updates", updates);

        return this;
    }

    public GetUpdates timeout(Integer timeout){
        add("timeout", timeout);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Update> exec() {
        Object response = requestSender.makeRequest(this);
        List<Object> updateList = Util.parse(response, List.class);
        return Util.parseList(updateList, Update.class);
    }
}

