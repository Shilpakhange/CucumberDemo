package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\Shilpa Khandge\\eclipse-workspace\\CucumberDemo\\src\\main\\java\\Features\\Tags.feature", //the path of the feature files
		glue={"stepDefinitions"},//the path of the step definition files
		plugin= {"pretty","html:test-outout"}, //to generate different types of reporting
		monochrome=true,//to generate console report in user readable format.
		dryRun=false,//It will check the mapping between feature file and step definition
		//strict=true//It will show if all the steps are definined according to the feature file
		//tags= {"@sanity"}//executes only sanity tests from tagsdefiniton class
		//tags= {"@sanity,@regression"}//executes either taged sanity or regression tests
		//tags= {"@smoke","@regression"}//executes both smoke and regression tests.
		tags= {"~@end2end"}//ignores test cases having tag end2end
		)

public class loginTestrunner {

}
