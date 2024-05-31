package et.telebof.types;

import java.io.Serializable;

public class InlineQueryResultsButton implements Serializable {
    private String text, start_parameter;
    private WebAppInfo web_app_info;

    public InlineQueryResultsButton(String text){
        this.text = text;
    }

    public InlineQueryResultsButton webAppInfo(WebAppInfo webAppInfo){
        this.web_app_info = webAppInfo;
        return this;
    }

    public InlineQueryResultsButton startParameter(String startParameter){
        this.start_parameter = startParameter;
        return this;
    }
}
