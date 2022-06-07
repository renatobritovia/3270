package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.testng.Assert;
import pageobjects.ExamplePage;

import static common.ListenerTest.reportPrintInfo;

public class ExampleSteps {
    @Dado("^Insiro o Username e Password$")
    public void insirirUsernameEPassword() {
        ExamplePage examplePage = new ExamplePage();
        examplePage.inserirUsername("username12");
        examplePage.inserirPassword("password12");
        reportPrintInfo("Preencheu username e password");
    }

    @Quando("^Reseto as credentiais$")
    public void clicarBotaoResetarCredenciais() {
        ExamplePage examplePage = new ExamplePage();
        examplePage.clicarBotaoReset();
    }

	@Entao("^Os campos Username e Password devem ser limpos$")
	public void usernameAndPassworShouldBeEmpty() {
		ExamplePage examplePage = new ExamplePage();
		Assert.assertTrue(examplePage.usernameAndPasswordFieldsShouldBeEmpty());
	}



}
