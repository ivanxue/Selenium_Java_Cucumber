package pageSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class AppiumSteps {
    private AppiumDriver<IOSElement> driver;
    private IOSElement table;
    private List<MobileElement> rows;

    @Given("^I launch the iOS app$")
    public void iLaunchTheIOSApp() throws MalformedURLException {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "app");
        File app = new File(appDir, "UICatalog.app");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "11.2");
        capabilities.setCapability("deviceName", "iPhone 6");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("automationName", "XCUITest");

        driver = new IOSDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Then("^I can see the table$")
    public void iCanSeeTheTable() {
        table = driver.findElementByClassName("XCUIElementTypeTable");
        assertNotNull(table);
    }

    @And("^Table row count is (\\d+) and first row is \"([^\"]*)\"$")
    public void tableRowCountIsAndFirstRowIs(int arg0, String arg1) {
        rows = table.findElementsByClassName("XCUIElementTypeCell");
        assertEquals(rows.size(), arg0);
        //is first one about buttons
        assertEquals(rows.get(0).findElementByClassName("XCUIElementTypeStaticText").getAttribute("name"), arg1);
    }

    @When("^I click the first row$")
    public void iClickTheFirstRow() {
        rows.get(0).click();
    }

    @Then("^Table cell value is \"([^\"]*)\"$")
    public void tableCellValueIs(String arg0) {
        rows = table.findElementsByClassName("XCUIElementTypeCell");
        assertEquals(rows.get(0).findElementByClassName("XCUIElementTypeStaticText").getAttribute("name"), arg0);
    }
}
