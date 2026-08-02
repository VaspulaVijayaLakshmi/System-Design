import appender.Appender;
import enums.LogLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import models.LogMessage;

public class Logger {

    //this is like run time config, like we give in app.yml
    //if we give INFO, it wont print debug and all logs

    private static Logger logger;

     LogLevel logLevelConfig;
     BlockingQueue<LogMessage> logQueue;
     List<Appender> appenders;


    private Logger(LogLevel logLevelConfig){

        this.logQueue = new LinkedBlockingQueue<>();
        this.appenders = new ArrayList<>();
        this.logLevelConfig = logLevelConfig;

        startWorker();

    }

     public static synchronized Logger getLogger(){
            if(logger == null){
                logger = new Logger(LogLevel.INFO);
            }
            return logger;
     }


     public void addAppender(Appender appender){
            appenders.add(appender);
     }


     public void log(String message, LogLevel level){

         //if the log level of this message is less than the current log level set , then u dont have to print
           if(logLevelConfig.ordinal() > level.ordinal()) return ;

           LogMessage logMessage = new LogMessage(level,message);

           logQueue.offer(logMessage);

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


        public void startWorker(){

        //thread workers
        Thread worker = new Thread(() -> {

             while(true){
                 try{

                     LogMessage logMessage = logQueue.take();

                     for(Appender appender : appenders){
                         appender.append(logMessage);
                     }

                 } catch (InterruptedException e) {
                     throw new RuntimeException(e);
                 }
             }
         });

         worker.start();

       }

}



