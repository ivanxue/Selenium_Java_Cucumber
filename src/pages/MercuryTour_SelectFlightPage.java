package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MercuryTour_SelectFlightPage extends BasePage {

	private static By continueReserve = By.name("reserveFlights");
	
	public MercuryTour_SelectFlightPage(WebDriver driver) {
		super(driver);
	}

	public static WebElement continueReserveBtn() {
		return driver.findElement(continueReserve);
	}
	
}
