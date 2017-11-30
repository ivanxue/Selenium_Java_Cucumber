package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class MercuryTour_LoginPage extends BasePage {
	
	private static WebElement element = null;
	private static By userName = By.name("userName");
	private static By password = By.name("password");
	private static By login = By.name("login");
	
	public MercuryTour_LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public static WebElement userNameInput() {
		try {
			element = driver.findElement(userName);
			Log.info("User Name field is found on the page");
		} catch (Exception error) {
			Log.error("User Name field is not found on the page");
			throw (error);
		}
		return element;
	}

	public static WebElement passwordInput() {
		try {
			element = driver.findElement(password);
			Log.info("Password field is found on the page");
		} catch (Exception error) {
			Log.error("Password field is not found on the page");
			throw (error);
		}
		return element;
	}

	public static WebElement signInBtn() {
		try {
			element = driver.findElement(login);
			Log.info("Sign-in button is found on the page");
		} catch (Exception error) {
			Log.error("Sign-in button is not found on the page");
			throw (error);
		}
		return element;
	}
	
	public static void login(String userName, String password) {
		userNameInput().sendKeys(userName);
		passwordInput().sendKeys(password);

		signInBtn().click();
	}

}
