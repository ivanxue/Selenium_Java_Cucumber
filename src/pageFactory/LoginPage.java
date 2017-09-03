package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(name="userName")
	WebElement userNameInput;
	
	@FindBy(name="password")
	WebElement passwordInput;
	
	@FindBy(name="login")
	WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login(String userName, String password) {
		userNameInput.sendKeys(userName);
		passwordInput.sendKeys(password);
		
		loginBtn.click();
	}
}
