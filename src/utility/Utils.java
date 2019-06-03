package utility;

import cucumber.api.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Utils {
    public static WebDriver driver = null;

    public static WebDriver openBrowser(String URL, String browserName) {
        try {

            driver = Browser.getBrowser(browserName);

            // set the timeout value for waiting for page to be loaded completely
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//			driver.manage().window().maximize();

            driver.get(URL);

        } catch (Exception error) {
            Reporter.log(error.getMessage());
        }
        return driver;
    }

    public static void validPageTitle(String expectedPageTitle) {
        String strPageTitle = driver.getTitle();
        System.out.println("Actual Page title: - " + strPageTitle);
        System.out.println("Expected Page title: - " + expectedPageTitle);
        Assert.assertTrue(strPageTitle.equalsIgnoreCase(expectedPageTitle), "Page title doesn't match");

    }

    public static void waitForElement(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // check radio button based on value
    public static void checkByValue(String name, String value) {
        // get the radio buttons or checkboxes based on name
        List<WebElement> selectOptions = driver.findElements(By.name(name));
        int iSize = selectOptions.size();
        // Start the loop from first option to last option
        for (int i = 0; i < iSize; i++) {
            String sValue = selectOptions.get(i).getAttribute("value");
            if (sValue.equalsIgnoreCase(value)) {
                selectOptions.get(i).click();
                break;
            }
        }
    }

    // select dropdown list based on value
    public static void selectByValue(String name, String value) {
        Select selectOptions = new Select(driver.findElement(By.name(name)));
        // selectOptions.deselectAll();
        selectOptions.selectByValue(value);
    }

    public static void takeScreenshot(WebDriver driver, Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            }
            driver.quit();
        } catch (Exception e) {
            System.out.println("Exception while running Tear down: " + e.getMessage());
        }
    }
}