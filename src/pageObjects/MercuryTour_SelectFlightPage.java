package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class MercuryTour_SelectFlightPage extends BasePage {
	
	private static WebElement element = null;
	
	public MercuryTour_SelectFlightPage(WebDriver driver) {
		super(driver);
	}

	public static WebElement continueReserveBtn() {
		try {
			element = driver.findElement(By.name("reserveFlights"));
			Log.info("Continue button at Reserve Flights is found on the page");
		} catch (Exception error) {
			Log.error("Continue button at Reserve Flights is not found on the page");
			throw (error);
		}
		return element;
	}
	
}
