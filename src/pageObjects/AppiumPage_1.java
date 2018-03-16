package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AppiumPage_1 {
    AppiumDriver appiumDriver;

    @FindBy(xpath = "//XCUIElementTypeTable")
    public static WebElement homePageTable;

    @FindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell")
    public static List<WebElement> homepageTableCells;

    @FindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText")
    public static List<WebElement> homepageTableCellTexts;

    public AppiumPage_1(AppiumDriver driver) {
        this.appiumDriver = driver;
        PageFactory.initElements(driver, this);
    }
}
