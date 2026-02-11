package formatter;

import models.LogMessage;

public interface Formatter {
    public String format(LogMessage message);
}
