import org.testng.Assert;
import org.testng.annotations.Test;

public class Test4 {
    @Test
    public void  testAssert1(){
        System.out.println("开始断言");
        Assert.assertEquals("1","1");
        System.out.println("结束断言");
    }

    @Test
    public void  testAssert2(){
        System.out.println("开始断言");
        Assert.assertEquals(1,2,"比较两个数是否相等：");
        System.out.println("结束断言");
    }

    @Test
    public void  testAssert3(){
        Assertion.begin();
        System.out.println("开始断言3");
        Assertion.verifyEquals(1,2,"比较两个数是否相等：");
        System.out.println("结束断言3");
        Assertion.end();
    }

    @Test
    public void  testAssert4(){
        Assertion.begin();
        System.out.println("开始断言4");
        Assertion.verifyEquals(1,1,"比较两个数是否相等：");
        System.out.println("结束断言4");
        Assertion.end();
    }

}
