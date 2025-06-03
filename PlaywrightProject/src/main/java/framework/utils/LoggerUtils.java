package framework.utils;

public class LoggerUtils {
    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger("Invaluable");

    public static void makeLog(String massage) {
        log.info(massage);
    }
    public static void makeWarningLog(String massage) {
        log.warning(massage);
    }
}