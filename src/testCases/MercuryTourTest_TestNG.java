package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.MercuryTour_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

public class MercuryTourTest_TestNG {
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
			Utils.waitForElement(MercuryTour_Page.userNameInput());
			MercuryTour_Page.validPageTitle("Welcome: Mercury Tours");

			MercuryTour_Page.login(sUserName, sPassword);

			Utils.waitForElement(MercuryTour_Page.tripTypeRadio());
			MercuryTour_Page.validPageTitle("Find a Flight: Mercury Tours:");

			MercuryTour_Page.findFlight(sDepartFrom, sArriveIn);

			Utils.waitForElement(MercuryTour_Page.continueReserveBtn());
			MercuryTour_Page.validPageTitle("Select a Flight: Mercury Tours");

			MercuryTour_Page.continueReserveBtn().click();

			Utils.waitForElement(MercuryTour_Page.firstNameInput());
			MercuryTour_Page.validPageTitle("Book a Flight: Mercury Tours");

			MercuryTour_Page.bookFlight(sFirstName, sLastName, sCreditNumber);

			Utils.waitForElement(MercuryTour_Page.backToHomeBtn());
			MercuryTour_Page.validPageTitle("Flight Confirmation: Mercury Tours");

			MercuryTour_Page.reviewFlight();
		}
		
		if (driver != null) {
			System.out.println("Closing browser");
			driver.quit();
		}
	}

	@AfterMethod
	public static void tearDown() throws Exception {
		Log.endTestCase();
	}
}
