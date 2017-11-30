package cucumberTest;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
//import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features",
		glue = {"stepDefinition"},
		plugin = {"pretty", "html:target/cucumber"}
		)

public class TestRunner extends AbstractTestNGCucumberTests {

}
