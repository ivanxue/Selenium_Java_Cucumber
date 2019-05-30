package utility;

/**
 * Created by ivanxue on 11/08/2017.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Browser {

    public static WebDriver driver;

    // remote server configuration in browserstack
    public static final String USERNAME = "feng20";
    public static final String AUTOMATE_KEY = "bxxkpf34hS1BKKyciXr2";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static DesiredCapabilities caps = new DesiredCapabilities();

    // please download and change the driver name based on your system
    public static WebDriver getBrowser(String browserType) throws MalformedURLException {
        String osName = System.getProperty("os.name");
        switch (browserType) {
            case "firefox":
                if (osName.contains("Mac")) {
                    System.setProperty("webdriver.gecko.driver", Constant.driverPath + "geckodriver");
                } else if (osName.contains("Windows")) {
                    System.setProperty("webdriver.gecko.driver", Constant.driverPath + "geckodriver.exe");
                }
                return driver = new FirefoxDriver();
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("no-sandbox");
                if (osName.contains("Mac")) {
                    System.setProperty("webdriver.chrome.driver", Constant.driverPath + "chromedriver");
                } else if (osName.contains("Windows")) {
                    System.setProperty("webdriver.chrome.driver", Constant.driverPath + "chromedriver.exe");
                }
                return driver = new ChromeDriver();
            case "safari":
                return driver = new SafariDriver();
            case "edge":
                System.setProperty("webdriver.edge.driver", Constant.driverPath + "MicrosoftWebDriver.exe");
                return driver = new EdgeDriver();
            case "remote":
                caps.setCapability("browser", "Firefox");
                caps.setCapability("browser_version", "48.0");
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browserstack.debug", "true");

                return driver = new RemoteWebDriver(new URL(URL), caps);
            default:
                System.out.println("browser: " + browserType + " is invalid, Launching Firefox as browser of choice..");
                return driver = new FirefoxDriver();
        }
    }
}