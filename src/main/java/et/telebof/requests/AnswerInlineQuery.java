package et.telebof.requests;

import et.telebof.types.InlineQueryResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    public AnswerInlineQuery switchPmText(String switchPmText) {
        return add("switch_pm_text", switchPmText);
    }

    public AnswerInlineQuery switchPmParameter(String switchPmParameter) {
        return add("switch_pm_parameter", switchPmParameter);
    }

    @Override
    public Boolean bind() {
        return (Boolean) requestSender.makeRequest(this);
    }
}
