package appender;

import models.LogMessage;

public interface Appender {

    public void append(LogMessage message);

}
