package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.*;
import utility.*;

public class MercuryTourTest_PageFactory {
	public static WebDriver driver;

	@Parameters({ "browser" })
	@BeforeClass
	public void launchBrowser(String browser) throws Exception {

		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase(this.getClass().getSimpleName());

		driver = Utils.openBrowser(Constant.url, browser);
	}

	@Parameters({ "userName", "password", "fromPort", "toPort", "firstName", "lastName", "creditNumber"})
	@Test
	public void main(String userName, String password, String fromPort, String toPort, String firstName, String lastName, String creditNumber) throws Exception {
			
			LoginPage objLogin = new LoginPage(driver);
			FindFlightsPage objFindFlight = new FindFlightsPage(driver);
			SelectFlightPage objSelectFlight = new SelectFlightPage(driver);
			BookFlightPage objBookFlight = new BookFlightPage(driver);
			ConfirmationPage objConfirmFlight = new ConfirmationPage(driver);

			Utils.validPageTitle("Welcome: Mercury Tours");

			objLogin.login(userName, password);
			Utils.validPageTitle("Find a Flight: Mercury Tours:");

			objFindFlight.findFlight(fromPort, toPort);
			Utils.validPageTitle("Select a Flight: Mercury Tours");

			objSelectFlight.reserveFlight();
			Utils.validPageTitle("Book a Flight: Mercury Tours");

			objBookFlight.bookFlight(firstName, lastName, creditNumber);
			Utils.validPageTitle("Flight Confirmation: Mercury Tours");
			
			objConfirmFlight.reviewFlight();
			
		
	}

	@AfterClass
	public static void tearDown() throws Exception {
		if (driver != null) {
			System.out.println("Closing browser");
			driver.close();
		}
		Log.endTestCase();
	}
}
