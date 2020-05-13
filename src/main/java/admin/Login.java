package admin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static admin.BusinessFlowPage.*;
import static admin.LoginPage.URL;

public class Login {
    public static WebDriver driver;

    public Login() {
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void loginAdmin() {
        Base.toURL(URL);
        LoginPage.USER.sendKeys("15902379217");
        LoginPage.PASSWORD.sendKeys("123456");
        LoginPage.CAPTCHA.sendKeys("0000");
        LoginPage.LOGIN.click();
        sleep(2000);
        //driver.findElement(By.linkText("周云腾"));
        driver.findElement(By.className("ant-dropdown-trigger")).isDisplayed();
    }

    @Test
    public void businessFlow() {
        loginAdmin();
        driver.get("http://admin.scm3.yunsom.cn/#/");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/aside/ul/li[2]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"46$Menu\"]/li[5]")).click();
        setValue();

        driver.findElements(By.className("ant-select-search ant-select-search--inline")).get(0).getText();
        String jsString1 = "document.getElementById('enterprise_id').style.display='block';";
        String jsString2 = "document.getElementsByClassName('ant-select-search ant-select-search--inline')[0].style.display='block';";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(jsString1);
        js.executeScript(jsString2);
        driver.findElement(By.id("enterprise_id")).sendKeys("aaa");
        sleep(2000);

        ADD.isDisplayed();
        VIEW.isDisplayed();
        SEARCH.isDisplayed();
        RELOAD.isDisplayed();
        sleep(2000);
        for (int i = 0; i < 8; i++) {
            Assert.assertEquals(titleList.get(i).getText(), titleListValue.get(i));
        }

        for (int i = 0; i < 3; i++) {
            Assert.assertEquals(selectList.get(i).getText(), selectListValue.get(i));
        }

        System.out.println(driver.findElement(By.className("ant-pagination-total-text")).getText().substring(2, 4));
        // Assert. assertTrue(driver.findElement(By.className("ant-pagination-total-text")).getText().substring(2,2).matches("39"));
        driver.findElement(By.xpath("//*[@id=\"enterprise_id\"]/div/div")).click();
        sleep(1000);
        driver.findElement(By.id("enterprise_id")).click();
        sleep(1000);

    }

    @AfterClass
    public void closeDriver() {
        driver.close();
    }
}
