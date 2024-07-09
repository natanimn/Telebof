package et.telebof.requests;

import et.telebof.types.InlineQueryResult;
import et.telebof.types.InlineQueryResultsButton;

import java.util.List;

public class AnswerInlineQuery extends AbstractBaseRequest<AnswerInlineQuery, Boolean> {

    public AnswerInlineQuery(String inlineQueryId, InlineQueryResult[] results, RequestSender requestSender) {
        super(requestSender, "answerInlineQuery");
        add("inline_query_id", inlineQueryId);
        add("results", List.of(results));
    }

    public AnswerInlineQuery cacheTime(int cacheTime) {
        return add("cache_time", cacheTime);
    }

    public AnswerInlineQuery isPersonal(boolean isPersonal) {
        return add("is_personal", isPersonal);
    }

    public AnswerInlineQuery nextOffset(String nextOffset) {
        return add("next_offset", nextOffset);
    }

    public AnswerInlineQuery button(InlineQueryResultsButton button){
        return add("button", button);
    }

}
