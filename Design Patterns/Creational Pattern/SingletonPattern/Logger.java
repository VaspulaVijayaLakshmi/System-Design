public class Logger {

    private static  Logger logger;

    //if we dont make logger private then class will create a default constructor for you
    //hence you create
    private Logger(){}

    public static synchronized Logger createLoggerInstance(){

        if(logger==null){
            logger = new Logger();
        }

        return logger;

    }


    public void log(String message){
        System.out.println("Log message: " + message);
    }

}
