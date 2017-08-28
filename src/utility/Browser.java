package utility;

/**
 * Created by ivanxue on 11/08/2017.
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Browser {

    public static WebDriver driver;
    
    // remote server configuration in testingbot
    public static final String KEY = "868c9ff90ed032ecfa27bd48ed89844a";
    public static final String SECRET = "af37e9afa932c9cb40133a7d28bc4ab0";
    public static final String URL = "http://" + KEY + ":" + SECRET + "@hub.testingbot.com/wd/hub";

    public static DesiredCapabilities caps = new DesiredCapabilities();

    // please download and change the driver name based on your system
    public static WebDriver getBrowser(String browserType) throws MalformedURLException {
        switch (browserType) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", Constant.driverPath + "geckodriver");
                return	driver = new FirefoxDriver();
            case "chrome":
            		ChromeOptions options = new ChromeOptions();
            		options.addArguments("no-sandbox");
                System.setProperty("webdriver.chrome.driver", Constant.driverPath + "chromedriver");
                return	driver = new ChromeDriver();
            case "htmlunit":
                return	driver = new HtmlUnitDriver();
            case "safari":
                return	driver = new SafariDriver();
            case "edge":
                System.setProperty("webdriver.edge.driver", Constant.driverPath + "MicrosoftWebDriver.exe");
                return	driver = new EdgeDriver();
            case "Remote":
                caps.setCapability("browserName", "IE");
                caps.setCapability("version", "11");
                caps.setCapability("platform", "WIN10");

                return driver = new RemoteWebDriver(new URL(URL), caps);
            default:
                System.out.println("browser: " + browserType + " is invalid, Launching Firefox as browser of choice..");
                return driver = new FirefoxDriver();
        }
    }
}