package utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Utils {
	public static WebDriver driver = null;

	public static WebDriver openBrowser(String URL, String browserName) throws Exception {
		try {

			driver = Browser.getBrowser(browserName);
			Log.info("New driver instantiated");

			// set the timeout value for waiting for page to be loaded completely
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Log.info("Implicit wait applied on the driver for 20 seconds");

//			driver.manage().window().maximize();

			driver.get(URL);
			Log.info("Navigate to " + URL + " successfully");

		} catch (Exception error) {
			Log.error("Class Utils | Method OpenBrowser | Exception desc : " + error.getMessage());
		}
		return driver;
	}
	
	public static void validPageTitle(String expectedPageTitle) {
		String strPageTitle = driver.getTitle();
		System.out.println("Actual Page title: - " + strPageTitle);
		System.out.println("Expected Page title: - " + expectedPageTitle);
		Assert.assertTrue(strPageTitle.equalsIgnoreCase(expectedPageTitle), "Page title doesn't match");
		
	}

	public static void waitForElement(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	// check radio button based on value
	public static void checkByValue(String name, String value) {
		// get the radio buttons or checkboxes based on name
		List<WebElement> selectOptions = driver.findElements(By.name(name));
		int iSize = selectOptions.size();
		// Start the loop from first option to last option
		for (int i = 0; i < iSize; i++) {
			String sValue = selectOptions.get(i).getAttribute("value");
			if (sValue.equalsIgnoreCase(value)) {
				selectOptions.get(i).click();
				break;
			}
		}
	}
	
	// select dropdown list based on value
	public static void selectByValue(String name, String value) {
		Select selectOptions = new Select(driver.findElement(By.name(name)));
		// selectOptions.deselectAll();
		selectOptions.selectByValue(value);
	}

	public static void takeScreenshot(WebDriver driver) throws Exception {
		DateFormat dateFormater = new SimpleDateFormat("yyyyMMdd-HH:mm:ss");
		String timeString = dateFormater.format(new Date());
		
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(Constant.Path_ScreenShot + timeString + ".jpg"));
		} catch (Exception error) {
			Log.error("Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : "
					+ error.getMessage());
			throw new Exception();
		}
	}
}