package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.InlineQueryResult;
import et.telebof.types.SentWebAppMessage;

public class AnswerWebAppQuery extends AbstractBaseRequest<AnswerWebAppQuery, SentWebAppMessage> {
    public AnswerWebAppQuery(String webAppQueryId, InlineQueryResult result, RequestSender requestSender) {
        super(requestSender, "answerWebAppQuery", SentWebAppMessage.class);
        add("web_app_query_id", webAppQueryId);
        add("result", result);
    }

}
