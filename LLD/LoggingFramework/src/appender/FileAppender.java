package appender;

import formatter.Formatter;
import models.LogMessage;

import java.io.FileWriter;

public class FileAppender implements  Appender {

    Formatter logFormatter;
    FileWriter fileWriter ;

    public FileAppender(Formatter logFormatter, String filePath) {
        this.logFormatter = logFormatter;

        try{
            fileWriter = new FileWriter(filePath);
        }catch(Exception e){
            System.out.println("Failed to create writer for file logs, exception: " + e.getMessage());
        }
    }


    @Override
    public void append(LogMessage logMessage) {
        try {
            fileWriter.write(logFormatter.format(logMessage));
        }catch(Exception e){
            System.out.println("Failed to write logs to file, exception: " + e.getMessage());
        }

    }
}
