package formatter;

import models.LogMessage;

public class DefaultFormatter implements Formatter{

    @Override
    public String format(LogMessage message) {

        return "message : " + message.getMessage() + " log level : " + message.getLogLevel() + " timestamp : " + message.getTimestamp();
    }
}
