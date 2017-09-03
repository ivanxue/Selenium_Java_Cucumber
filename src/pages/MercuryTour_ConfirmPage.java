package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class MercuryTour_ConfirmPage extends BasePage {
	private static WebElement element = null;
	
	public MercuryTour_ConfirmPage(WebDriver dirver) {
		super(driver);
		
	}

	public static WebElement backToHomeBtn() {
		try {
			element = driver.findElement(By.xpath("//*/tbody/tr[7]/td/table/tbody/tr/td[2]/a"));
			Log.info("Back To Home button is found on the page");
		} catch (Exception error) {
			Log.error("Back To Home button is not found on the page");
			throw (error);
		}
		return element;
	}

	public static WebElement logoutBtn() {
		try {
			element = driver.findElement(By.xpath("//*/tbody/tr[7]/td/table/tbody/tr/td[3]/a"));
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
