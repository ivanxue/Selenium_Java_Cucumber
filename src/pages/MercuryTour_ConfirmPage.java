package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;

public class MercuryTour_ConfirmPage extends BasePage {

	private static WebElement element = null;
	private static By backToHome = By.xpath("//*/tbody/tr[7]/td/table/tbody/tr/td[2]/a");
	private static By logout = By.xpath("//*/tbody/tr[7]/td/table/tbody/tr/td[3]/a");
	
	
	public MercuryTour_ConfirmPage(WebDriver dirver) {
		super(driver);
		
	}

	public static WebElement backToHomeBtn() {
		try {
			element = driver.findElement(backToHome);
			Log.info("Back To Home button is found on the page");
		} catch (Exception error) {
			Log.error("Back To Home button is not found on the page");
			throw (error);
		}
		return element;
	}

	public static WebElement logoutBtn() {
		try {
			element = driver.findElement(logout);
			Log.info("Log Out button is found on the page");
		} catch (Exception error) {
			Log.error("Log Out button is not found on the page");
			throw (error);
		}
		return element;
	}
	
	public static void reviewFlight() {
		backToHomeBtn().click();
	}
}
