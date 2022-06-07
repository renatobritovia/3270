package loginClientes;

import org.openqa.selenium.support.PageFactory;

public class MenusPage extends MenusElementMap {
	
	public MenusPage() {
		PageFactory.initElements(BaseTest.getDriver(), this);
	}
	
	public void acessarMenusClienteInserir(){
		BaseTest baseclass = new BaseTest();

		if(mensagemInicial.isDisplayed()) {
			baseclass.waitElement(mensagemInicial);
			btnComecar.click();
		}
		menuCliente.click();	
	}
	
	public void telaInicial() {
		
	}

}
