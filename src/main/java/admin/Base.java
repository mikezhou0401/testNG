package admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Base {
    public static WebDriver driver = Login.driver;

    public static void toURL(String url) {
        driver.get(url);
    }

    public static WebElement findElement(String locator, String type) {
        WebElement webElement = null;
        switch (type) {
            case ("id"):
                webElement = driver.findElement(By.id(locator));
                break;
            case ("xpath"):
                webElement = driver.findElement(By.xpath(locator));
                break;
            case ("css"):
                webElement = driver.findElement(By.cssSelector(locator));
                break;
            case ("name"):
                webElement = driver.findElement(By.name(locator));
                break;
            case ("classname"):
                webElement = driver.findElement(By.className(locator));
                break;
            case ("linkText"):
                webElement = driver.findElement(By.linkText(locator));
                break;
            case ("partialLinkText"):
                webElement = driver.findElement(By.partialLinkText(locator));
                break;
            case ("tagName"):
                webElement = driver.findElement(By.tagName(locator));
                break;
            default:
                System.out.println(locator + "不存在");
                break;
        }
        return webElement;
    }
}
