public class LoggingFrameworkDemo {

    public static void main(String[] args){

        // Get logger from factory
        Logger logger = LoggerFactory.getLogger("User Service");

        // Logging examples
        logger.debug("This is a DEBUG log");
        logger.info("Application started successfully");
        logger.error("Something went wrong!");



    }
}
