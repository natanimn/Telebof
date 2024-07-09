package et.telebof.requests;

import et.telebof.types.ReactionType;

import java.util.List;

public class SetMessageReaction extends AbstractBaseRequest<SetMessageReaction, Boolean>{
    public SetMessageReaction(Object chatId, int message_id, RequestSender requestSender){
        super(chatId, requestSender, "setMessageReaction");
    }

    public SetMessageReaction reaction(List<ReactionType> reaction){
        return add("reaction", reaction);
    }

    public SetMessageReaction isBig(boolean is_big){
        return add("is_big", is_big);
    }

}
