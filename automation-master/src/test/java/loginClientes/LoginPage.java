package loginClientes;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends LoginElementMap{
	
	private static WebDriver driver;
	
	public LoginPage() {
		PageFactory.initElements(BaseTest.getDriver(), this);
	}
	

	public void efetuarLoginNaPagina() {
		inputEmail.sendKeys("andre.fernando.berte@gmail.com");
		inputPassword.sendKeys("AndreBerte");
		btnLogin.click();
		//pageCard -> usar depois
	}
	
	public void cupom() {
		btnOpcoesMensal.equals("Pagamento Mensal");
		cupomDescont.sendKeys("TEST-FBMY-RDDR");
		btnAplicar.click();
		btnConfirmaCard.click();
	}
	
	public void cadastroCartao(String numCard, String nomeCard, String cpf, String dataNascimentoCard,
			String mesVencimentoCard, String anoVencimentoCard, String cvv, String numParcelasCard) {
		
		numCartao.sendKeys("4111111111111111");
		nomeCartao.sendKeys("John Smith");
		numCpf.sendKeys("60892916095");
		dataNascimento.sendKeys("31081989");
		mesVencimento.sendKeys("Fev");
		anoVencimento.sendKeys("2020");
		cvvCard.sendKeys("737");
		numParcelas.sendKeys("06");
		btnConfirmaCard.click();
		
		// btnOpcoesMensal.click();
		// cupomDesconto.sendKeys("TEST"); String cupomDesccontoCard (colocar na chamada do method)
		// btnInvestimentoMensal.click();
		//setaAvancar.click();
		// btnSetaAvancar.click(); caso precise rolar para o lado
	}
	
	public void loginFacebook() {
		btnFacebook.click();
	}
	
	public void loginGoogle() {
		btnGoogle.click();
	}
	
	public void loginLinkedin() {
		btnLinkedin.click();
	}
}
