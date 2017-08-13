package stepDefinition;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObjects.BasePage;
import pageObjects.MercuryTour_Page;
import utility.Constant;
import utility.Utils;;

public class MercuryTour {
	
	public static WebDriver driver;
	
	@Given("^url opened$")
	public void url_opened() throws Throwable {
		driver = Utils.openBrowser(Constant.url, "chrome");
		new BasePage(driver);
	}

	@Then("^enter user id as \"([^\"]*)\"$")
	public void enter_user_id(String userName) throws Throwable {
	    MercuryTour_Page.userNameInput().sendKeys(userName);
	}

	@Then("^enter password as \"([^\"]*)\"$")
	public void enter_password(String password) throws Throwable {
	    MercuryTour_Page.passwordInput().sendKeys(password);
	}

	@Then("^click login$")
	public void click_login() throws Throwable {
	    MercuryTour_Page.signInBtn().click();
	}

	@Then("^close browser$")
	public void close_browser() throws Throwable {
	    driver.quit();
	}

}
