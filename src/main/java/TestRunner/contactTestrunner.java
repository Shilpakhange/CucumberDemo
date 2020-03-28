package TestRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\Shilpa Khandge\\eclipse-workspace\\CucumberDemo\\src\\main\\java\\Features\\Hooks.feature", //the path of the feature files
		glue={"stepDefinitions"},//the path of the step definition files
		plugin= {"pretty","html:test-outout"}, //to generate different types of reporting
		monochrome=true,
		dryRun=false,
		strict=true
		)

public class contactTestrunner {

}
