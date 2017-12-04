package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.*;

public class MercuryTour_FindFlightsPage extends BasePage {

	private static By tripType = By.name("tripType");
	private static By from = By.name("fromPort");
	private static By to = By.name("toPort");
	private static By servClass = By.name("servClass");
	private static By continueFind = By.name("findFlights");
	
	public MercuryTour_FindFlightsPage(WebDriver driver) {
		super(driver);
	}

	public static WebElement tripTypeRadio() {
		return driver.findElement(tripType);
	}

	public static WebElement fromDropdown() {
		return driver.findElement(from);
	}

	public static WebElement toDropdown() {
		return driver.findElement(to);
	}

	public static WebElement servClassRadio() {
		return driver.findElement(servClass);
	}

	public static WebElement continueFindBtn() {
		return driver.findElement(continueFind);
	}
	
	public static void findFlight(String departFrom, String arriveIn) {
		Utils.checkByValue("tripType", "oneway");
		Utils.selectByValue("fromPort", departFrom);
		Utils.selectByValue("toPort", arriveIn);
		Utils.checkByValue("servClass", "First");

		continueFindBtn().click();
	}

}
