import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class DateSource {
    public Map<String, Object[][]> dataSource() {
        Map<String, Object[][]> dataMap = new HashMap<String, Object[][]>();
        TestEnum[] te = TestEnum.values();
        Object[][] o1 = new Object[te.length][];
        for (int i = 0; i < te.length; i++) {
            o1[i]= new Object[]{te[i]};
        }
        dataMap.put("testDemo", o1);
        Object[][] o2 = new Object[][]{{5, 6}, {7, 8}};
        dataMap.put("testDemo1", o2);
        return dataMap;
    }
}
