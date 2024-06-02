package et.telebof.errors;

public class ConnectionError extends RuntimeException{
    public ConnectionError(String msg){
        super(msg);
    }
}
