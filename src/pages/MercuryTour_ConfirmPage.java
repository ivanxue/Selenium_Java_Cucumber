package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MercuryTour_ConfirmPage extends BasePage {

	private static By backToHome = By.xpath("//*/tbody/tr[7]/td/table/tbody/tr/td[2]/a");
	
	public MercuryTour_ConfirmPage(WebDriver driver) {
		super(driver);
		
	}

	public static WebElement backToHomeBtn() {
		return driver.findElement(backToHome);
	}
	
	public static void reviewFlight() {
		backToHomeBtn().click();
	}
}
