package test.java.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.java.utility.Utils;

public class FindFlightsPage {
	WebDriver driver;
	
	@FindBy(name="tripType")
	WebElement tripTypeRadio;
	
	@FindBy(name="fromPort")
	WebElement fromDropdown;
	
	@FindBy(name="toPort")
	WebElement toDropdown;
	
	@FindBy(name="servClass")
	WebElement servClassRadio;
	
	@FindBy(name="findFlights")
	WebElement continueFindBtn;
	
	public FindFlightsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void findFlight(String departFrom, String arriveIn) {
		Utils.checkByValue("tripType", "oneway");
		Utils.selectByValue("fromPort", departFrom);
		Utils.selectByValue("toPort", arriveIn);
		Utils.checkByValue("servClass", "First");
		
		continueFindBtn.click();
	}
}
