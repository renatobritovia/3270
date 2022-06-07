package loginClientes;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;

public class ClienteSteps {
	
	@Dado("^abro na pagina de login e insiro meu usuario e senha$")
	public void loginNoSistema() {
		LoginPage loginPage = new LoginPage();
		loginPage.efetuarLoginNaPagina();
		//loginPage.cupom(); -> usar em outro momento
	}
	
	@E("^acessei o menu Clientes Inserir$")
	public void acessei_o_menu_Clientes_Inserir(){
		MenusPage menusPage = new MenusPage();
		menusPage.acessarMenusClienteInserir();
	}
	
	@Entao ("^na tela Dados de Identificacao informo os dados de Pessoa Fisica$")
	public void informoCurso() {
		ClientePage clientePage = new ClientePage();
		clientePage.clicandoNoMenuCliente();
		clientePage.acessadoMenuCliente();
	}
	
	@Dado("que clico no login por facebook")
	public void logarFace() {
		LoginPage loginPage = new LoginPage();
	}
	
	@E("coloco o email")
	public void informarEmail() {
		LoginPage loginPage = new LoginPage();
	}
	
	@E("senha")
	public void senhaFace() {
		LoginPage loginPage = new LoginPage();
	}
	
	@Entao("clico em acessar")
	public void acessaFacebook() {
		LoginPage loginPage = new LoginPage();
	}
	@Dado("que clico no login por google")
	public void logarGoogle() {
		LoginPage loginPage = new LoginPage();
	}
	
	@E("coloco o email google")
	public void informarEmailGoogle() {
		LoginPage loginPage = new LoginPage();
	}
	
	@E("senha google")
	public void senhaGoogle() {
		LoginPage loginPage = new LoginPage();
	}
	
	@Entao("clico em acessar google")
	public void acessaGoogle() {
		LoginPage loginPage = new LoginPage();
	}
	@Dado("que clico no login por linkedin")
	public void logarLinkedin() {
		LoginPage loginPage = new LoginPage();
	}
	
	@E("coloco o email linkedin")
	public void informarEmailLinkedin() {
		LoginPage loginPage = new LoginPage();
	}
	
	@E("senha linkedin")
	public void senhaLinkedin() {
		LoginPage loginPage = new LoginPage();
	}
	
	@Entao("clico em acessar linkedin")
	public void acessaLinkedin() {
		LoginPage loginPage = new LoginPage();
	}	
}
