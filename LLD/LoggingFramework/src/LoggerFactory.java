import appender.ConsoleAppender;
import enums.LogLevel;
import formatter.DefaultFormatter;

import java.util.HashMap;
import java.util.Map;

public class LoggerFactory {

    static Map<String, Logger> loggerMap = new HashMap<>();

    public static Logger getLogger(String name) {

        // if logger already exists, return it
        if (loggerMap.containsKey(name)) {
            return loggerMap.get(name);
        }

        //example...creation
        Logger logger = new Logger(LogLevel.INFO);
        loggerMap.put(name, logger);

        // default configuration
        logger.addAppender(new ConsoleAppender(new DefaultFormatter()));

        return logger;

    }

}



//levelConfig.put("UserService", LogLevel.DEBUG);
//levelConfig.put("PaymentService", LogLevel.ERROR);


//So for each service we have a global logger
//So when user service is there, we return the same logger again and again.


