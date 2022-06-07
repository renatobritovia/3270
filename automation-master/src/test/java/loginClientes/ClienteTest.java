package loginClientes;

import org.junit.Rule;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"features/Login.feature"}, 
		format={"pretty","html:target/Reports"},
		glue = { "" },tags = {"@test"},monochrome = true, dryRun = false)

public class ClienteTest {
	
	@Rule
	BaseTest baseTest = new BaseTest();

}
