package loginClientes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ClienteElementMap {
	
	public ClienteElementMap() {
		PageFactory.initElements(BaseTest.getDriver(), this);
	}

	protected WebElement login; 
	protected WebElement avancar; 
	
}
