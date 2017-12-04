package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MercuryTour_BookFlightPage extends BasePage {

    private static By firstName = By.name("passFirst0");
    private static By lastName = By.name("passLast0");
    private static By creditNumber = By.name("creditnumber");
    private static By ticketlessTravel = By.name("ticketLess");
    private static By securePurchase = By.name("buyFlights");

    public MercuryTour_BookFlightPage(WebDriver driver) {
        super(driver);
    }


    public static WebElement firstNameInput() throws Exception {
        return driver.findElement(firstName);
    }

    public static WebElement lastNameInput() throws Exception {
        return driver.findElement(lastName);
    }

    public static WebElement creditNumberInput() throws Exception {
        return driver.findElement(creditNumber);
    }

    public static WebElement ticketlessTravelCheck() throws Exception {
        return driver.findElement(ticketlessTravel);
    }

    public static WebElement securePurchaseBtn() throws Exception {
        return driver.findElement(securePurchase);
    }

    public static void bookFlight(String firstName, String lastName, String creditNumber) throws Exception {
        firstNameInput().sendKeys(firstName);
        lastNameInput().sendKeys(lastName);
        creditNumberInput().sendKeys(creditNumber);

        ticketlessTravelCheck().click();
        securePurchaseBtn().click();
    }

}