import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDemo {
    //@BeforeMethod
    public void testBeforeMethod() {
        System.out.println("this is  before method");
    }

    //@AfterMethod
    public void testAfterMethod() {
        System.out.println("this is after method!");
    }


    @Test(dataProvider = "dataDemo")
    public void test1(int a,int b){
       int sum=a+b;
       System.out.println(sum);
    }
    @DataProvider(name="dataDemo")
    public Object[][] dataProvider(){
        return new Object[][]{{1,2},{3,4}};
    }

}
