package et.telebof.types;


import java.io.Serializable;

public class WriteAccessAllowed extends JsonSerializable implements Serializable {
    private String web_app_name;

    public WriteAccessAllowed webAppName(String webAppName){
        this.web_app_name = webAppName;
        return this;
    }

}
