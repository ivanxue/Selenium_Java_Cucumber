package cucumberTest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/cucumberTest/MercuryTour.feature",
		format={"pretty","html:target/Reports"}
		)

public class TestRunner {

}
