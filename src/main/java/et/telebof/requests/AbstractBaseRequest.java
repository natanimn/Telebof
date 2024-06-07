package et.telebof.requests;

import et.telebof.Util;
import java.io.File;
import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings("unchecked")
abstract public class AbstractBaseRequest<T, R>{
    Map<String, Object> parameters = new TreeMap<>();
    private String contentType = MediaContentType.DEFAULT;
    private boolean hasMultipart;
    T type = (T) this;
    Class<? extends R> rClass;
    protected String methodName ;
    protected RequestSender requestSender;

    public AbstractBaseRequest(Object chatId, RequestSender requestSender, String methodName) {
        add("chat_id", chatId);
        this.requestSender = requestSender;
        this.methodName = methodName;
    }

    public AbstractBaseRequest(RequestSender requestSender, String methodName) {
        this.methodName = methodName;
        this.requestSender = requestSender;
    }

    final protected T add(String key, Object values) {
        parameters.put(key, values);
        if (!hasMultipart)
            this.setHasMultipart(values instanceof File);
        return type;
    }

    protected void setHasMultipart(boolean hasMultipart) {
        this.hasMultipart = hasMultipart;
    }

    protected Map<String, Object> getParameters() {
        return parameters;
    }

    protected String getMethodName() {
        return methodName;
    }

    protected boolean hasMultipart() {
        return hasMultipart;
    }

    protected void setContentType(String contentType){
         this.contentType = contentType;
    }

    protected String getContentType() {
        return contentType;
    }

    @Deprecated(since = "v1.2.0")
    public R bind(){
        return exec();
    }

    public abstract R exec();

}
