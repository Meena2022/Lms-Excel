package User_LMSApiSteps;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
features="src/test/resources/User_LMSApiFeatures",
glue={"User_LMSApiSteps"},
plugin = {"pretty"},
dryRun=false,
monochrome=true

)
public class LMSTestRunner {

}
