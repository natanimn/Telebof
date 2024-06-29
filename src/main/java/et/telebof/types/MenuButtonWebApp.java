package et.telebof.types;

import java.io.Serializable;

public class MenuButtonWebApp extends MenuButton implements Serializable {
    public WebAppInfo web_app;
    public MenuButtonWebApp(String text, WebAppInfo webApp) {
        super("web_app");
        this.web_app = webApp;
    
    }
}
