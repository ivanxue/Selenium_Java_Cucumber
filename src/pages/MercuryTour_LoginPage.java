package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MercuryTour_LoginPage extends BasePage {

	private static By userName = By.name("userName");
	private static By password = By.name("password");
	private static By login = By.name("login");
	
	public MercuryTour_LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public static WebElement userNameInput() {
		return driver.findElement(userName);
	}

	public static WebElement passwordInput() {
		return driver.findElement(password);
	}

	public static WebElement signInBtn() {
		return driver.findElement(login);
	}
	
	public static void login(String userName, String password) {
		userNameInput().sendKeys(userName);
		passwordInput().sendKeys(password);

		signInBtn().click();
	}

}
