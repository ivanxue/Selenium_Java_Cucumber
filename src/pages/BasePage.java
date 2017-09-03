package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    public static WebDriver driver;
    public static boolean bResult;
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        BasePage.bResult = true;
    }
}