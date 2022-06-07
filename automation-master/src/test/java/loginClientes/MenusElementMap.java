package loginClientes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenusElementMap {
	
	public MenusElementMap() {
		PageFactory.initElements(BaseTest.getDriver(), this);
	}

	@FindBy(xpath = "//div[@class='col-10 objetivos-personalizar--desc-usuario text-body-pi']")
	protected WebElement mensagemInicial;
	
	@FindBy(xpath = "//button[@class='btn btn-blue btn-FontWeight6']")
	protected WebElement btnComecar;
	
	@FindBy(xpath = "//a[text()='Clientes']")
	protected WebElement menuCliente;
	
}
