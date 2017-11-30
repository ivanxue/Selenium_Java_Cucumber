package test.java.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
	WebDriver driver;
	
	@FindBy(xpath="//*/tbody/tr[7]/td/table/tbody/tr/td[2]/a")
	WebElement backToHomeBtn;
	
	@FindBy(xpath="//*/tbody/tr[7]/td/table/tbody/tr/td[3]/a")
	WebElement logoutBtn;

	public ConfirmationPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void reviewFlight() {
		backToHomeBtn.click();
	}
	
	
}
