package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import test.java.utility.Log;
import test.java.utility.Utils;

public class MercuryTour_BookFlightPage extends BasePage {
	
	private static WebElement element = null;
	private static By firstName = By.name("passFirst0");
	private static By lastName = By.name("passLast0");
	private static By creditNumber = By.name("creditnumber");
	private static By ticketlessTravel = By.name("ticketLess");
	private static By securePurchase = By.name("buyFlights");
	
	public MercuryTour_BookFlightPage(WebDriver driver) {
		super(driver);
	}
	
	
	public static WebElement firstNameInput() throws Exception {
		try {
			element = driver.findElement(firstName);
			Log.info("First Name field is found on the page");
		} catch (Exception error) {
			Utils.takeScreenshot(driver);
			Log.error("First Name field is not found on the page");
			throw (error);
		}
		return element;
	}

	public static WebElement lastNameInput() throws Exception {
		try {
			element = driver.findElement(lastName);
			Log.info("Last Name field is found on the page");
		} catch (Exception error) {
			Utils.takeScreenshot(driver);
			Log.error("Last Name field is not found on the page");
			throw (error);
		}
		return element;
	}

	public static WebElement creditNumberInput() throws Exception {
		try {
			element = driver.findElement(creditNumber);
			Log.info("Credit Card number field is found on the page");
		} catch (Exception error) {
			Utils.takeScreenshot(driver);
			Log.error("Credit Card number is not found on the page");
			throw (error);
		}
		return element;
	}

	public static WebElement ticketlessTravelCheck() throws Exception {
		try {
			element = driver.findElement(ticketlessTravel);
			Log.info("Ticketless Travel checkbox is found on the page");
		} catch (Exception error) {
			Utils.takeScreenshot(driver);
			Log.error("Ticketless Travel checkbox is not found on the page");
			throw (error);
		}
		return element;
	}

	public static WebElement securePurchaseBtn() throws Exception {
		try {
			element = driver.findElement(securePurchase);
			Log.info("Secure Purchase button is found on the page");
		} catch (Exception error) {
			Utils.takeScreenshot(driver);
			Log.error("Secure Purchase button is not found on the page");
			throw (error);
		}
		return element;
	}
	
	public static void bookFlight(String firstName, String lastName, String creditNumber) throws Exception {
		firstNameInput().sendKeys(firstName);
		lastNameInput().sendKeys(lastName);
		creditNumberInput().sendKeys(creditNumber);

		ticketlessTravelCheck().click();
		securePurchaseBtn().click();
	}

}
