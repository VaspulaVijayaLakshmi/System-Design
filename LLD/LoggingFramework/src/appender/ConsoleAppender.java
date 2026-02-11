package appender;

import formatter.Formatter;
import models.LogMessage;

public class ConsoleAppender implements Appender {

    Formatter logFormatter;

    public ConsoleAppender(Formatter logFormatter) {
        this.logFormatter = logFormatter;
    }

    @Override
    public void append(LogMessage logMessage) {
        System.out.println(logFormatter.format(logMessage));
    }

}
