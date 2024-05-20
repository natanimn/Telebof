package et.telebof;
import java.util.logging.*;

public class BotLog {
    static Logger logger;

    static {
        logger = Logger.getLogger("Telebof");
        logger.setLevel(Level.CONFIG);
    }
    public static void info(String text){
        logger.info(text);
    }

    public static void error(String text){
        logger.severe(text);
    }

    public static void warn(String text){
        logger.warning(text);
    }

    public static void debug(String text){
        logger.config(text);
    }
}
