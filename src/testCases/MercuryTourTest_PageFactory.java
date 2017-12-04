package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.*;
import utility.Constant;
import utility.Utils;

public class MercuryTourTest_PageFactory {
	public static WebDriver driver;
	public LoginPage loginPage;
	public FindFlightsPage findFlightsPage;
	public SelectFlightPage selectFlightPage;
	public BookFlightPage bookFlightPage;
	public ConfirmationPage confirmationPage;

	@Parameters({ "browser" })
	@BeforeClass
	public void launchBrowser(String browser) throws Exception {

		driver = Utils.openBrowser(Constant.url, browser);
		loginPage = new LoginPage(driver);
		findFlightsPage = new FindFlightsPage(driver);
		selectFlightPage = new SelectFlightPage(driver);
		bookFlightPage = new BookFlightPage(driver);
		confirmationPage = new ConfirmationPage(driver);
	}

	@Parameters({ "userName", "password" })
	@Test(priority=1)
	public void login(String userName, String password) throws Exception {

		// wait the page to be loaded completely and verify the page title
		Utils.waitForElement(loginPage.userNameInput);
		Utils.validPageTitle("Welcome: Mercury Tours");

		LoginPage.login(userName, password);

		Utils.waitForElement(findFlightsPage.tripTypeRadio);
		Utils.validPageTitle("Find a Flight: Mercury Tours:");
	}

	@Parameters({ "fromPort", "toPort" })
	@Test(priority=2)
	public void findFlight(String fromPort, String toPort) throws Exception {

		findFlightsPage.findFlight(fromPort, toPort);

		Utils.waitForElement(selectFlightPage.reserveBtn);
		Utils.validPageTitle("Select a Flight: Mercury Tours");

		selectFlightPage.reserveFlight();

		Utils.waitForElement(bookFlightPage.firstNameInput);
		Utils.validPageTitle("Book a Flight: Mercury Tours");
	}

	@Parameters({ "firstName", "lastName", "creditNumber" })
	@Test(priority=3)
	public void selectFlight(String firstName, String lastName, String creditNumber) throws Exception {

		bookFlightPage.bookFlight(firstName, lastName, creditNumber);

		Utils.waitForElement(confirmationPage.backToHomeBtn);
		Utils.validPageTitle("Flight Confirmation: Mercury Tours");
	}

	@Test(priority=4)
	public void confirmFlight() throws Exception {
		confirmationPage.reviewFlight();
	}

	@AfterClass
	public static void tearDown() throws Exception {
		if (driver != null) {
			System.out.println("Closing browser");
			driver.close();
		}
	}
}
