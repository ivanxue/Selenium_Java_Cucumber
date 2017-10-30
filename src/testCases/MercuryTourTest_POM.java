package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.MercuryTour_BookFlightPage;
import pages.MercuryTour_ConfirmPage;
import pages.MercuryTour_FindFlightsPage;
import pages.MercuryTour_LoginPage;
import pages.MercuryTour_SelectFlightPage;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

public class MercuryTourTest_POM {
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

	@BeforeTest
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

	@Parameters({ "browser" })
	@Test
	public void main(String browser) throws Exception {

		for (int i = 1; i < iRowCount; i++) {
			// get the browser type from the data file first, including chrome, firefox,
			// remote etc.
			sBrowserName = ExcelUtils.getCellData(i, Constant.Col_Browser, "MercuryTour");

			// call openBrowser function to launch different browser which is indicated in
			// data file
			driver = Utils.openBrowser(Constant.url, browser);
			new BasePage(driver);

			// get test data from the data file based on row, column and sheet name
			sUserName = ExcelUtils.getCellData(i, Constant.Col_UserName, "MercuryTour");
			sPassword = ExcelUtils.getCellData(i, Constant.Col_Password, "MercuryTour");
			sDepartFrom = ExcelUtils.getCellData(i, Constant.Col_DepartFrom, "MercuryTour");
			sArriveIn = ExcelUtils.getCellData(i, Constant.Col_ArriveIn, "MercuryTour");
			sFirstName = ExcelUtils.getCellData(i, Constant.Col_FirstName, "MercuryTour");
			sLastName = ExcelUtils.getCellData(i, Constant.Col_LastName, "MercuryTour");
			sCreditNumber = ExcelUtils.getCellData(i, Constant.Col_CreditNumber, "MercuryTour");

			// wait the page to be loaded completely and verify the page title
			Utils.waitForElement(MercuryTour_LoginPage.userNameInput());
			Utils.validPageTitle("Welcome: Mercury Tours");

			MercuryTour_LoginPage.login(sUserName, sPassword);

			Utils.waitForElement(MercuryTour_FindFlightsPage.tripTypeRadio());
			Utils.validPageTitle("Find a Flight: Mercury Tours:");

			MercuryTour_FindFlightsPage.findFlight(sDepartFrom, sArriveIn);

			Utils.waitForElement(MercuryTour_SelectFlightPage.continueReserveBtn());
			Utils.validPageTitle("Select a Flight: Mercury Tours");

			MercuryTour_SelectFlightPage.continueReserveBtn().click();

			Utils.waitForElement(MercuryTour_BookFlightPage.firstNameInput());
			Utils.validPageTitle("Book a Flight: Mercury Tours");

			MercuryTour_BookFlightPage.bookFlight(sFirstName, sLastName, sCreditNumber);

			Utils.waitForElement(MercuryTour_ConfirmPage.backToHomeBtn());
			Utils.validPageTitle("Flight Confirmation: Mercury Tours");

			MercuryTour_ConfirmPage.reviewFlight();
		}
		
		if (driver != null) {
			System.out.println("Closing browser");
			driver.quit();
		}
	}

	@AfterTest
	public static void tearDown() throws Exception {
//		driver.quit();
		Log.endTestCase();
	}
}
