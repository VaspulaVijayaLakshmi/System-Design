package Creational.Singleton;

public class Main {

    public static void main(String[] args){

        Logger logger1 = Logger.createLoggerInstance();
        logger1.log("This is the first log message.");


        Logger logger2 = Logger.createLoggerInstance();
        logger2.log("This is the second log message.");

        System.out.println("Are both logger instances the same? " + (logger1 == logger2));

    }
}
