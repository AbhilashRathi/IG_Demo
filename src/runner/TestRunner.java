package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/feature"
		,glue={"stepDefinition/"}
		,tags= {"@test"}
		,plugin = {"pretty", "html:target/cucumber-reports"}
		)

public class TestRunner {

}
