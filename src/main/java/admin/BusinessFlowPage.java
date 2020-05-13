package admin;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BusinessFlowPage {
    public static final WebElement ADD = Base.findElement("//*[@id=\"root\"]/div/div/div/div/div[1]/div/div[2]/button[1]", "xpath");
    public static final WebElement VIEW = Base.findElement("//*[@id=\"root\"]/div/div/div/div/div[1]/div/div[2]/button[2]", "xpath");
    public static  final WebElement SEARCH=Base.findElement("//*[@id=\"root\"]/div/div/div/div/div[1]/div/div[2]/div[1]/div[2]/button[1]/span","xpath");
    public static  final WebElement RELOAD=Base.findElement("//*[@id=\"root\"]/div/div/div/div/div[1]/div/div[2]/div[1]/div[2]/button[2]/span","xpath");
    public static List<WebElement> titleList = new ArrayList<>();
    public static List<String> titleListValue = new ArrayList<>();
    public static List<WebElement> selectList = new ArrayList<>();
    public static List<String> selectListValue = new ArrayList<>();

    public static void setValue() {
        for (int i = 0; i < 8; i++) {
            int j=i+1;
            titleList.add(Base.findElement("//*[@id=\"root\"]/div/div/div/div/div[1]/div/div[2]/div[2]/div/div/div/div/div/div/table/thead/tr/th["+j+"]/span/div/span[1]", "xpath"));
        }

        for (int i = 0; i < 3; i++) {
            int j=i+1;
            selectList.add(Base.findElement("//*[@id=\"root\"]/div/div/div/div/div[1]/div/div[2]/div[1]/div[1]/div/div["+j+"]/div/div[1]/label","xpath"));
        }
        titleListValue.add(0, "序号");
        titleListValue.add(1, "业务流程");
        titleListValue.add(2, "所属产品");
        titleListValue.add(3, "所属企业");
        titleListValue.add(4, "流程方案");
        titleListValue.add(5, "流程类型");
        titleListValue.add(6, "流程状态");
        titleListValue.add(7, "操作");

        selectListValue.add(0,"企业名称：");
        selectListValue.add(1,"流程类型：");
        selectListValue.add(2,"流程状态：");
    }


}
