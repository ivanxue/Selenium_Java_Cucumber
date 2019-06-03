package pageSteps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pageObjects.FindFlightsPage;
import pageObjects.LoginPage;
import utility.Constant;
import utility.Utils;

import static org.testng.Assert.assertEquals;

public class MercuryTour {

    public static WebDriver driver;
    public LoginPage loginPage;
    public FindFlightsPage findFlightsPage;

    @Given("^url opened with browser ([^\"]*)$")
    public void url_opened(String browser) {
        driver = Utils.openBrowser(Constant.url, browser);
        loginPage = new LoginPage(driver);
        findFlightsPage = new FindFlightsPage(driver);
    }

    @When("^enter user id as ([^\"]*)$")
    public void enterUserIdAsUserName(String userName) {
        LoginPage.userNameInput.sendKeys(userName);
    }

    @And("^enter password as ([^\"]*)$")
    public void enterPasswordAsPassword(String password) {
        LoginPage.passwordInput.sendKeys(password);
    }

    @And("^click login$")
    public void click_login() {
        LoginPage.loginBtn.click();
    }

    @Then("^select flight form exists$")
    public void selectFlightFormExists() {
        assertEquals(FindFlightsPage.fromDropdown.isDisplayed(), false);
    }

    @After
    public void tearDown(Scenario scenario) {
        Utils.takeScreenshot(driver, scenario);
    }
}
