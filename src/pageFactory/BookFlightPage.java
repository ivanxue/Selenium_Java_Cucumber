package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookFlightPage {
	WebDriver driver;
	
	@FindBy(name="passFirst0")
	public static WebElement firstNameInput;
	
	@FindBy(name="passLast0")
	public static WebElement lastNameInput;
	
	@FindBy(name="creditnumber")
	public static WebElement creditNumberInput;
	
	@FindBy(name="ticketLess")
	public static WebElement ticketlessTravelCheck;
	
	@FindBy(name="buyFlights")
	public static WebElement securePurchaseBtn;

	public BookFlightPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static void bookFlight(String firstName, String lastName, String creditNumber) {
		firstNameInput.sendKeys(firstName);
		lastNameInput.sendKeys(lastName);
		creditNumberInput.sendKeys(creditNumber);

		ticketlessTravelCheck.click();
		securePurchaseBtn.click();
	}

}
