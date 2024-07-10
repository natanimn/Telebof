package et.telebof.requests;

import et.telebof.types.StarTransactions;

public class GetStarTransactions extends AbstractBaseRequest<GetStarTransactions, StarTransactions> {

    public GetStarTransactions(RequestSender requestSender){
      super(requestSender, "getStarTransactions", StarTransactions.class);
    }

    public GetStarTransactions offset(int offset){
        return add("offset", offset);
    }

    public GetStarTransactions limit(int limit){
        return add("limit", limit);
    }
}
