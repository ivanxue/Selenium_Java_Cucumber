package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectFlightPage {
	WebDriver driver;
	
	@FindBy(name="reserveFlights")
	WebElement reserveBtn;
	
	public SelectFlightPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void reserveFlight() {
		reserveBtn.click();
	}

}
