package test.java.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookFlightPage {
	WebDriver driver;
	
	@FindBy(name="passFirst0")
	WebElement firstNameInput;
	
	@FindBy(name="passLast0")
	WebElement lastNameInput;
	
	@FindBy(name="creditnumber")
	WebElement creditNumberInput;
	
	@FindBy(name="ticketLess")
	WebElement ticketlessTravelCheck;
	
	@FindBy(name="buyFlights")
	WebElement securePurchaseBtn;

	public BookFlightPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void bookFlight(String firstName, String lastName, String creditNumber) {
		firstNameInput.sendKeys(firstName);
		lastNameInput.sendKeys(lastName);
		creditNumberInput.sendKeys(creditNumber);

		ticketlessTravelCheck.click();
		securePurchaseBtn.click();
	}

}
