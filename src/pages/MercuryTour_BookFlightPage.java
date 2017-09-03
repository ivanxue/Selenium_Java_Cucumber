package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class MercuryTour_BookFlightPage extends BasePage {
	
	private static WebElement element = null;
	
	public MercuryTour_BookFlightPage(WebDriver driver) {
		super(driver);
	}
	
	
	public static WebElement firstNameInput() {
		try {
			element = driver.findElement(By.name("passFirst0"));
			Log.info("First Name field is found on the page");
		} catch (Exception error) {
			Log.error("First Name field is not found on the page");
			throw (error);
		}
		return element;
	}

	public static WebElement lastNameInput() {
		try {
			element = driver.findElement(By.name("passLast0"));
			Log.info("Last Name field is found on the page");
		} catch (Exception error) {
			Log.error("Last Name field is not found on the page");
			throw (error);
		}
		return element;
	}

	public static WebElement creditNumberInput() {
		try {
			element = driver.findElement(By.name("creditnumber"));
			Log.info("Credit Card number field is found on the page");
		} catch (Exception error) {
			Log.error("Credit Card number is not found on the page");
			throw (error);
		}
		return element;
	}

	public static WebElement ticketlessTravelCheck() {
		try {
			element = driver.findElement(By.name("ticketLess"));
			Log.info("Ticketless Travel checkbox is found on the page");
		} catch (Exception error) {
			Log.error("Ticketless Travel checkbox is not found on the page");
			throw (error);
		}
		return element;
	}

	public static WebElement securePurchaseBtn() {
		try {
			element = driver.findElement(By.name("buyFlights"));
			Log.info("Secure Purchase button is found on the page");
		} catch (Exception error) {
			Log.error("Secure Purchase button is not found on the page");
			throw (error);
		}
		return element;
	}
	
	public static void bookFlight(String firstName, String lastName, String creditNumber) {
		firstNameInput().sendKeys(firstName);
		lastNameInput().sendKeys(lastName);
		creditNumberInput().sendKeys(creditNumber);

		ticketlessTravelCheck().click();
		securePurchaseBtn().click();
	}

}
