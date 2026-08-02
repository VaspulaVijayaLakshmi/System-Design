public class LoggingFrameworkDemo {

    public static void main(String[] args){

        Logger logger = Logger.getLogger();

        Formatter formatter = new DefaultFormatter();

        Appender consoleAppender = new ConsoleAppender(formatter);

        logger.addAppender(consoleAppender);

        logger.info("App started");
        logger.error("Error log");
    }

}
