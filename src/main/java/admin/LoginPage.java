package admin;

import org.openqa.selenium.WebElement;

public class LoginPage {

    public static final String URL="http://admin.scm3.yunsom.cn/#/login";
    public static final WebElement USER = Base.findElement("#root > div > div.body__lCzT4 > div > div > form > div:nth-child(1) > div > div > span > span > input","css");
    public static final WebElement PASSWORD = Base.findElement("#root > div > div.body__lCzT4 > div > div > form > div:nth-child(2) > div > div > span > span > input","css");
    public static final WebElement CAPTCHA = Base.findElement("#root > div > div.body__lCzT4 > div > div > form > div:nth-child(3) > div > div > span > span.ant-input-affix-wrapper > input","css");
    public static final WebElement LOGIN = Base.findElement("#root > div > div.body__lCzT4 > div > div > form > div:nth-child(4) > div > div > span > div > button","css");
}
