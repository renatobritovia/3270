package loginClientes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginElementMap {
	
	public LoginElementMap() {
		PageFactory.initElements(BaseTest.getDriver(), this);
	}
	
	protected WebElement inputEmail;
	protected WebElement inputPassword;
	
	@FindBy(xpath = "//button[@class='btn btn-login float-right ml-auto false']")
	protected WebElement btnLogin;
	
	@FindBy(xpath = "//div[@id='pagamento--assine-lit']")
	protected WebElement pageCard;
	
	@FindBy(xpath = "//input[@name='CCnumber']")
	protected WebElement numCartao;
	
	@FindBy(xpath = "//input[@name='CCname']")
	protected WebElement nomeCartao;
	
	@FindBy(xpath = "//input[@name='cpf']")
	protected WebElement numCpf;
	
	@FindBy(xpath = "//input[@name='nascimento']")
	protected WebElement dataNascimento;
	
	@FindBy(xpath = "//select[@name='mesvencimento']")
	protected WebElement mesVencimento;
	
	@FindBy(xpath = "//select[@name='anovencimento']")
	protected WebElement anoVencimento;
	
	@FindBy(xpath = "//input[@name='cvc']")
	protected WebElement cvvCard;
	
	@FindBy(xpath = "//select[@name='parcelas']")
	protected WebElement numParcelas;
	
	@FindBy(xpath = "//input[@name='cupom']")
	protected WebElement cupomDesconto;
	
	@FindBy(xpath = "//p[@class='font-weight-bold mb-0 mt-1']")
	protected WebElement numConfirmParcelas;
	
	@FindBy(xpath = "//button[text()='Confirmar']")
	protected WebElement btnConfirmaCard;
	
	/* Opções de Pagamento */

	@FindBy(xpath = "//input[@name='cupom']")
	protected WebElement cupomDescont;
	
	@FindBy(xpath = "//a[@class='btn btn-lg btn-lightfalse']")
	protected WebElement btnAplicar;
	
	@FindBy(xpath = "//button[@class='btn btn-blue mr-3 btn-block']")
	protected WebElement btnOpcoesMensal;
	
	@FindBy(xpath = "//h2[text()='Genial Investimentos']")
	protected WebElement btnInvestimentoMensal;
	
	@FindBy(xpath = "//div[@class='sc-ifAKCX geRExE sc-EHOje aoTUt']")
	protected WebElement btnSetaAvancarLado;
	
	@FindBy(xpath = "//button[@id='next-button']")
	protected WebElement setaAvancar;
	
	
	/* Login por Facebook*/
	
	@FindBy(xpath = "//i[@class='fa fa-facebook']")
	protected WebElement btnFacebook;
	
	/* Login Pelo Google*/
	
	@FindBy(xpath = "//img[@alt='iconGoogle']")
	protected WebElement btnGoogle;
	
	/*Login pelo Linkedin*/
	
	@FindBy(xpath = "//img[@alt='LinkedinIcon']")
	protected WebElement btnLinkedin;	
}
