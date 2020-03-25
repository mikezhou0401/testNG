import org.apache.log4j.Logger;
public class TestLog {
private Logger logger= Logger.getLogger(this.getClass());
public void  testlog(){
        logger.error("this is error log！");
        logger.info("this is info log！");
        logger.debug("this is debug log!");
        logger.warn("this is warn log!");
        logger.fatal("this is fatal log!");
    }
    public  static void main(String[] args){
        TestLog testLog=new TestLog();
        testLog.testlog();
    }
}
