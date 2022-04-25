package LMSApiStepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
/*
@RunWith(Cucumber.class)
@CucumberOptions(
features="src/test/resources/LMS_ApiFeatures",
glue={"LMSApiStepDefinitions"},
plugin = {"pretty","html:target/HtmlReports/LMSAPI_Test.html"},
publish = true,
monochrome=true,
tags="@getTest"

)
*/

 //Post Method using Excel File Test Runner
@RunWith(Cucumber.class)
@CucumberOptions(
features="src/test/resources/LMS_ApiFeatures/LMSPostXls.feature",
glue={"LMSApiStepDefinitions"},
plugin = {"pretty","html:target/HtmlReports/LMSAPI_Test.html"},
monochrome=true
)


public class LMSApiTestRunner {

}



