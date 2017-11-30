package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import test.java.utility.Log;

public class MercuryTour_SelectFlightPage extends BasePage {
	
	private static WebElement element = null;
	private static By continueReserve = By.name("reserveFlights");
	
	public MercuryTour_SelectFlightPage(WebDriver driver) {
		super(driver);
	}

	public static WebElement continueReserveBtn() {
		try {
			element = driver.findElement(continueReserve);
			Log.info("Continue button at Reserve Flights is found on the page");
		} catch (Exception error) {
			Log.error("Continue button at Reserve Flights is not found on the page");
			throw (error);
		}
		return element;
	}
	
}
