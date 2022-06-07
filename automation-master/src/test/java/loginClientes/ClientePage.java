package loginClientes;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ClientePage extends ClienteElementMap{
	
	public ClientePage() {
		PageFactory.initElements(BaseTest.getDriver(), this);
		
	}

	public void clicandoNoMenuCliente() { 
		// TODO Auto-generated method stub
		
	}

	public void acessadoMenuCliente() {
		// TODO Auto-generated method stub
		
	}
	public void clicarAvancar() {
		avancar.click();
		
	}

}
