package stepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pageFactory.FindFlightsPage;
import pageFactory.LoginPage;
import utility.Constant;
import utility.Utils;

import static org.testng.Assert.assertEquals;

public class MercuryTour {

    public static WebDriver driver;
    public LoginPage loginPage;
    public FindFlightsPage findFlightsPage;

    @Given("^url opened with browser ([^\"]*)$")
    public void url_opened(String browser) throws Throwable {
        driver = Utils.openBrowser(Constant.url, browser);
        loginPage = new LoginPage(driver);
        findFlightsPage = new FindFlightsPage(driver);
    }

    @When("^enter user id as ([^\"]*)$")
    public void enterUserIdAsUserName(String userName) throws Throwable {
        loginPage.userNameInput.sendKeys(userName);
    }

    @And("^enter password as ([^\"]*)$")
    public void enterPasswordAsPassword(String password) throws Throwable {
        loginPage.passwordInput.sendKeys(password);
    }

    @And("^click login$")
    public void click_login() throws Throwable {
        loginPage.loginBtn.click();
    }

    @Then("^select flight form exists$")
    public void selectFlightFormExists() throws Throwable {
        assertEquals(findFlightsPage.fromDropdown.isDisplayed(), true);
    }

    @After
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }

    }
}
