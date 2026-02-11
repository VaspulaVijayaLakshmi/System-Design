import appender.Appender;
import enums.LogLevel;

import java.util.ArrayList;
import java.util.List;
import models.LogMessage;

public class Logger {

    //this is like run time config, like we give in app.yml
    //if we give INFO, it wont print debug and all logs

     LogLevel logLevelConfig;
     List<Appender> appenders;


     public Logger(LogLevel logLevelConfig){
        this.appenders = new ArrayList<>();
        this.logLevelConfig = logLevelConfig;
     }

        public void addAppender(Appender appender){
            appenders.add(appender);
        }

        public void log(String message, LogLevel level){

         //if the log level of this message is less than the current log level set , then u dont have to print
           if(logLevelConfig.ordinal() > level.ordinal()) return ;

           LogMessage logMessage = new LogMessage(level,message);

           for(Appender appender : appenders){
               appender.append(logMessage);
           }

        }

        public void debug(String message){
           log(message, LogLevel.DEBUG);
        }

        public void info(String message){
            log(message,LogLevel.INFO);

        }

        public void error(String message){
            log(message,LogLevel.ERROR);
        }

}
