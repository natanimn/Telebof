package et.telebof.requests;

import et.telebof.Util;
import et.telebof.types.InlineQueryResult;
import et.telebof.types.SentWebAppMessage;

public class AnswerWebAppQuery extends AbstractBaseRequest<AnswerWebAppQuery, SentWebAppMessage> {
    public AnswerWebAppQuery(String webAppQueryId, InlineQueryResult result, RequestSender requestSender) {
        super(requestSender, "answerWebAppQuery");
        add("web_app_query_id", webAppQueryId);
        add("result", result);
    }

    @Override
    public SentWebAppMessage exec() {
        return Util.parse(requestSender.makeRequest(this), SentWebAppMessage.class);
    }
}
