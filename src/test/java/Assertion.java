import org.testng.Assert;

public class Assertion {
    public static boolean flag = true;

    public  static void begin(){
        flag=true;
    }
    public  static void end(){
        Assert.assertTrue(flag);
    }

    public static void verifyEquals(Object actul, Object excepted) {
        try {
            Assert.assertEquals(actul, excepted);
        } catch (Error e) {
            flag=false;
        }
    }

    public static void verifyEquals(Object actul, Object excepted, String message) {
        try {
            Assert.assertEquals(actul, excepted, message);
        } catch (Error e) {
            flag=false;
        }
    }

}
