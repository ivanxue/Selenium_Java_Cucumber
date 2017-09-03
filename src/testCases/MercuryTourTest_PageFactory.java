package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageFactory.BookFlightPage;
import pageFactory.ConfirmationPage;
import pageFactory.FindFlightsPage;
import pageFactory.LoginPage;
import pageFactory.SelectFlightPage;
import pages.MercuryTour_BookFlightPage;
import pages.MercuryTour_ConfirmPage;
import pages.MercuryTour_FindFlightsPage;
import pages.MercuryTour_LoginPage;
import pages.MercuryTour_SelectFlightPage;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

public class MercuryTourTest_PageFactory {
	public static WebDriver driver;
	private String sTestCaseName;
	private int iRowCount;
	private String sBrowserName;
	private String sUserName;
	private String sPassword;
	private String sDepartFrom;
	private String sArriveIn;
	private String sFirstName;
	private String sLastName;
	private String sCreditNumber;

	@BeforeMethod
	public void beforeMethod() throws Exception {

		DOMConfigurator.configure("log4j.xml");

		// get test case name from the data file and start writing logs
		sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.startTestCase(sTestCaseName);

		// load the data file and check the number of test cases which need to be run
		// (data-driven)
		ExcelUtils.loadExcelFile(Constant.dataPath + Constant.dataFile);
		iRowCount = ExcelUtils.getRowCount("MercuryTour");
	}

	@Test
	public void main() throws Exception {

		for (int i = 1; i < iRowCount; i++) {
			// get the browser type from the data file first, including chrome, firefox,
			// remote etc.
			sBrowserName = ExcelUtils.getCellData(i, Constant.Col_Browser, "MercuryTour");

			// call openBrowser function to launch different browser which is indicated in
			// data file
			driver = Utils.openBrowser(Constant.url, sBrowserName);

			// get test data from the data file based on row, column and sheet name
			sUserName = ExcelUtils.getCellData(i, Constant.Col_UserName, "MercuryTour");
			sPassword = ExcelUtils.getCellData(i, Constant.Col_Password, "MercuryTour");
			sDepartFrom = ExcelUtils.getCellData(i, Constant.Col_DepartFrom, "MercuryTour");
			sArriveIn = ExcelUtils.getCellData(i, Constant.Col_ArriveIn, "MercuryTour");
			sFirstName = ExcelUtils.getCellData(i, Constant.Col_FirstName, "MercuryTour");
			sLastName = ExcelUtils.getCellData(i, Constant.Col_LastName, "MercuryTour");
			sCreditNumber = ExcelUtils.getCellData(i, Constant.Col_CreditNumber, "MercuryTour");
			
			LoginPage objLogin = new LoginPage(driver);
			FindFlightsPage objFindFlight = new FindFlightsPage(driver);
			SelectFlightPage objSelectFlight = new SelectFlightPage(driver);
			BookFlightPage objBookFlight = new BookFlightPage(driver);
			ConfirmationPage objConfirmFlight = new ConfirmationPage(driver);

			Utils.validPageTitle("Welcome: Mercury Tours");

			objLogin.login(sUserName, sPassword);
			Utils.validPageTitle("Find a Flight: Mercury Tours:");

			objFindFlight.findFlight(sDepartFrom, sArriveIn);
			Utils.validPageTitle("Select a Flight: Mercury Tours");

			objSelectFlight.reserveFlight();
			Utils.validPageTitle("Book a Flight: Mercury Tours");

			objBookFlight.bookFlight(sFirstName, sLastName, sCreditNumber);
			Utils.validPageTitle("Flight Confirmation: Mercury Tours");
			
			objConfirmFlight.reviewFlight();
		}
		
		if (driver != null) {
			System.out.println("Closing browser");
			driver.close();
		}
	}

	@AfterMethod
	public static void tearDown() throws Exception {
		driver.quit();
		Log.endTestCase();
	}
}
