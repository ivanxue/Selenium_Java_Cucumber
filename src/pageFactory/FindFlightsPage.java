package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Utils;

public class FindFlightsPage {
	WebDriver driver;
	
	@FindBy(name="tripType")
	public static WebElement tripTypeRadio;
	
	@FindBy(name="fromPort")
	public static WebElement fromDropdown;
	
	@FindBy(name="toPort")
	public static WebElement toDropdown;
	
	@FindBy(name="servClass")
	public static WebElement servClassRadio;
	
	@FindBy(name="findFlights")
	public static WebElement continueFindBtn;
	
	public FindFlightsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static void findFlight(String departFrom, String arriveIn) {
		Utils.checkByValue("tripType", "oneway");
		Utils.selectByValue("fromPort", departFrom);
		Utils.selectByValue("toPort", arriveIn);
		Utils.checkByValue("servClass", "First");
		
		continueFindBtn.click();
	}
}
