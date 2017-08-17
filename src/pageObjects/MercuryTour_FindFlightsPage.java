package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
import utility.Utils;

public class MercuryTour_FindFlightsPage extends BasePage {
	
	private static WebElement element = null;
	
	public MercuryTour_FindFlightsPage(WebDriver driver) {
		super(driver);
	}

	public static WebElement tripTypeRadio() {
		try {
			element = driver.findElement(By.name("tripType"));
			Log.info("Trip Type radio button is found on the page");
		} catch (Exception error) {
			Log.error("Trip Type radio button is not found on the page");
			throw (error);
		}
		return element;
	}

	public static WebElement fromDropdown() {
		try {
			element = driver.findElement(By.name("fromPort"));
			Log.info("Depart from dropdown is found on the page");
		} catch (Exception error) {
			Log.error("Depart from dropdown is not found on the page");
			throw (error);
		}
		return element;
	}

	public static WebElement toDropdown() {
		try {
			element = driver.findElement(By.name("toPort"));
			Log.info("Arrive in dropdown is found on the page");
		} catch (Exception error) {
			Log.error("Arrive in dropdown is not found on the page");
			throw (error);
		}
		return element;
	}

	public static WebElement servClassRadio() {
		try {
			element = driver.findElement(By.name("servClass"));
			Log.info("Service Class radio button is found on the page");
		} catch (Exception error) {
			Log.error("Service Class radio button is not found on the page");
			throw (error);
		}
		return element;
	}

	public static WebElement continueFindBtn() {
		try {
			element = driver.findElement(By.name("findFlights"));
			Log.info("Continue button at Find Flights is found on the page");
		} catch (Exception error) {
			Log.error("Continue button at Find Flights is not found on the page");
			throw (error);
		}
		return element;
	}
	
	public static void findFlight(String departFrom, String arriveIn) {
		Utils.checkByValue("tripType", "oneway");
		Utils.selectByValue("fromPort", departFrom);
		Utils.selectByValue("toPort", arriveIn);
		Utils.checkByValue("servClass", "First");

		continueFindBtn().click();
	}

}
