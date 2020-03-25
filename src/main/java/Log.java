import org.apache.log4j.Logger;
import org.testng.Reporter;

public class Log {
    private Logger logger;
    public  Log(Class<?> clazz){
        logger=Logger.getLogger(clazz);
    }
    public  Log(String s){
        logger=Logger.getLogger(s);
    }
    public  Log(){
        logger=Logger.getLogger("");
    }
    public  void info(Object message){
        logger.info(message);
    }
    public void  error( Object message){
        logger.error(message);
    }
    public void warn(Object message){
        logger.warn(message);
    }
    public void debug(Object message){
        logger.debug(message);
    }
    private void testngLogOutput(Object message){
        Reporter.log(message.toString());
    }
}
