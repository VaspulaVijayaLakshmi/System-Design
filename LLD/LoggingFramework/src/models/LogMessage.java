package models;

import enums.LogLevel;

import java.time.LocalDateTime;

public class LogMessage {

    LogLevel LogLevel;
    String message;
    LocalDateTime timestamp;

    public LogMessage(LogLevel LogLevel, String message) {
        this.LogLevel = LogLevel;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public String getMessage(){
        return  message;
    }

    public String getLogLevel(){
        return LogLevel.toString();
    }

    public String getTimestamp(){
        return LocalDateTime.now().toString();
    }

}
