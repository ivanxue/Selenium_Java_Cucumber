package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;
import utility.Constant;
import utility.Utils;

public class MercuryTourTest_POM {
	public static WebDriver driver;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeMethod(String browser) throws Exception {

		driver = Utils.openBrowser(Constant.url, browser);
		new BasePage(driver);
	}

	@Parameters({ "userName", "password" })
	@Test(priority=1)
	public void login(String userName, String password) throws Exception {

		// wait the page to be loaded completely and verify the page title
		Utils.waitForElement(MercuryTour_LoginPage.userNameInput());
		Utils.validPageTitle("Welcome: Mercury Tours");

		MercuryTour_LoginPage.login(userName, password);

		Utils.waitForElement(MercuryTour_FindFlightsPage.tripTypeRadio());
		Utils.validPageTitle("Find a Flight: Mercury Tours:");
	}

	@Parameters({ "fromPort", "toPort" })
	@Test(priority=2)
	public void findFlight(String fromPort, String toPort) throws Exception {

		MercuryTour_FindFlightsPage.findFlight(fromPort, toPort);

		Utils.waitForElement(MercuryTour_SelectFlightPage.continueReserveBtn());
		Utils.validPageTitle("Select a Flight: Mercury Tours");

		MercuryTour_SelectFlightPage.continueReserveBtn().click();

		Utils.waitForElement(MercuryTour_BookFlightPage.firstNameInput());
		Utils.validPageTitle("Book a Flight: Mercury Tours");
	}

	@Parameters({ "firstName", "lastName", "creditNumber" })
	@Test(priority=3)
	public void selectFlight(String firstName, String lastName, String creditNumber) throws Exception {

		MercuryTour_BookFlightPage.bookFlight(firstName, lastName, creditNumber);

		Utils.waitForElement(MercuryTour_ConfirmPage.backToHomeBtn());
		Utils.validPageTitle("Flight Confirmation: Mercury Tours");
	}

	@Test(priority=4)
	public void confirmFlight() throws Exception {
		MercuryTour_ConfirmPage.reviewFlight();
	}

	@AfterClass
	public static void tearDown() throws Exception {
		if (driver != null) {
			System.out.println("Closing browser");
			driver.quit();
		}
	}
}
