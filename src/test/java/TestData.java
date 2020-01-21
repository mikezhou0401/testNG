import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class TestData {
    @DataProvider
    public Object[][] dataProvider(Method method) {
        DateSource date = new DateSource();
        Object[][] obj = date.dataSource().get(method.getName());
        return obj;
    }
    @Test(dataProvider = "dataProvider")
    public void testDemo(TestEnum te) {
        System.out.println("retCode is:" + te.getRetCode() +
                "retMsg is：" + te.getRetMsg());
    }

    @Parameters({"a","b"})
    @Test
    public void testDemo1(int a, int b) {
        int sum = a + b;
        System.out.println("this is sum:" + sum);
    }
}
