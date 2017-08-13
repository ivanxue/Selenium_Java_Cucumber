package cucumberTest;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObjects.BaseClass;
import pageObjects.MercuryTour_Page;
import utility.Constant;
import utility.Utils;;

public class stepDefinition {
	
	public static WebDriver driver;
	
	@Given("^url opened$")
	public void url_opened() throws Throwable {
		driver = Utils.openBrowser(Constant.url, "chrome");
		new BaseClass(driver);
	}

	@Then("^enter user id$")
	public void enter_user_id() throws Throwable {
	    MercuryTour_Page.userNameInput().sendKeys("mercury");
	}

	@Then("^enter password$")
	public void enter_password() throws Throwable {
	    MercuryTour_Page.passwordInput().sendKeys("mercury");
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
