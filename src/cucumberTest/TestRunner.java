package cucumberTest;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
//import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"features/MercuryTour.feature"},
		glue = {"pageSteps"},
//		plugin = {"pretty", "html:target/cucumber"},
		format = {"json:target/cucumber.json","html:target/cucumber-pretty"}
		)

public class TestRunner extends AbstractTestNGCucumberTests {

}
