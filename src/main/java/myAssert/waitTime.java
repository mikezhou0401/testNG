package myAssert;

import admin.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitTime {

    public static void  waitExist(){
        WebDriver driver= Login.driver;
        new WebDriverWait(driver,20,500).until(ExpectedConditions.presenceOfElementLocated(By.id("su")));
    }
}
