package pageobjects;

import common.BasePO;
import common.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ExampleElementMap {
	
	public ExampleElementMap() {
		PageFactory.initElements(BaseTest.getDriver(), this);
	}
	
	WebElement uid;
	WebElement password;
	WebElement btnReset;
}
