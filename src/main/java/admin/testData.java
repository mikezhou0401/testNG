package admin;

import org.testng.annotations.DataProvider;

public class testData {
    @DataProvider(name="dataDemo")
    public  Object[][] dataProvider(){
        return new Object[][]{{1,2},{3,4}};
    }
}
