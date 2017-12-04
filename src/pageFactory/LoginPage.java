package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(name="userName")
	public static WebElement userNameInput;
	
	@FindBy(name="password")
	public static WebElement passwordInput;
	
	@FindBy(name="login")
	public static WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static void login(String userName, String password) {
		userNameInput.sendKeys(userName);
		passwordInput.sendKeys(password);
		
		loginBtn.click();
	}
}
