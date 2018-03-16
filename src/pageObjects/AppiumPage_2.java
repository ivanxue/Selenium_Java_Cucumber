package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AppiumPage_2 {

    AppiumDriver appiumDriver;

    @FindBy(xpath = "//XCUIElementTypeTable")
    public static WebElement childPageTable;

    @FindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell")
    public static List<WebElement> childpageTableCells;

    @FindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText")
    public static List<WebElement> childpageTableCellTexts;

    public AppiumPage_2(AppiumDriver driver) {
        this.appiumDriver = driver;
        PageFactory.initElements(driver, this);
    }
}
