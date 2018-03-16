package pageSteps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageObjects.AppiumPage_1;
import pageObjects.AppiumPage_2;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class AppiumSteps {
    private AppiumDriver<IOSElement> driver;
    public AppiumPage_1 appiumPage_1;
    public AppiumPage_2 appiumPage_2;

    private AppiumDriverLocalService appiumService;

    @Before
    public void startAppiumServer() {
        appiumService = AppiumDriverLocalService.buildDefaultService();
        appiumService.start();
    }

    @Given("^I launch the iOS app$")
    public void iLaunchTheIOSApp() throws MalformedURLException {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "app");
        File app = new File(appDir, "UICatalog.app");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "11.2");
        capabilities.setCapability("deviceName", "iPhone 6");
        capabilities.setCapability("fullReset", "true");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("automationName", "XCUITest");

        driver = new IOSDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        appiumPage_1 = new AppiumPage_1(driver);
        appiumPage_2 = new AppiumPage_2(driver);
    }

    @Then("^I can see the table$")
    public void iCanSeeTheTable() {
        assertNotNull(AppiumPage_1.homePageTable);
    }

    @And("^Table row count is (\\d+) and first row is \"([^\"]*)\"$")
    public void tableRowCountIsAndFirstRowIs(int arg0, String arg1) {
        assertEquals(AppiumPage_1.homepageTableCells.size(), arg0);
        assertEquals(AppiumPage_1.homepageTableCellTexts.get(0).getAttribute("value"), arg1);
    }

    @When("^I click the first row$")
    public void iClickTheFirstRow() {
        AppiumPage_1.homepageTableCells.get(0).click();
    }

    @Then("^Table cell value is \"([^\"]*)\"$")
    public void tableCellValueIs(String arg0) {
        assertEquals(AppiumPage_2.childpageTableCellTexts.get(0).getAttribute("name"), arg0);
    }

    @After
    public void stopAppiumServer(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                final byte[] screenshot = driver.getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            }
            appiumService.stop();
            driver.quit();
        } catch (Exception e) {
            System.out.println("Exception while running Tear down: " + e.getMessage());
        }
    }
}
