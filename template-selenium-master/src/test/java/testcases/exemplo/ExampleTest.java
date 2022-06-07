package testcases.exemplo;

import common.BaseTest;
import cucumber.api.CucumberOptions;

@CucumberOptions(
		features = {"classpath:features"},
		plugin = {"pretty"},
		glue = { "steps", "pageobjects", "testcases/exemplo", "common" },tags = {"@reset"},monochrome = true)
public class ExampleTest extends BaseTest {

}
