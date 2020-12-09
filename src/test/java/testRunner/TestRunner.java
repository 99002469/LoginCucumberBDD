package testRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

	@RunWith(Cucumber.class)                   
	@CucumberOptions(
			features="src/test/resources/Feature/LoginApi.feature",         
	        glue = {"stepDefinitions"},
	        monochrome = true,
//			tags = "@UI",
			plugin = {"pretty", "junit:target/automationreport.xml"})  

public class TestRunner {

}
