package et.telebof.errors;

public class TelegramError extends RuntimeException{
    public TelegramError(String msg){
        super(msg);
    }
}
