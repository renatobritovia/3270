package pageobjects;

import com.aventstack.extentreports.Status;
import common.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static common.ListenerTest.reportPrintElement;

public class ExamplePage extends ExampleElementMap {

	private WebDriver driver;
	private WebDriverWait wait;

	public ExamplePage() {
		driver = BaseTest.getDriver();
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void inserirUsername(String username){
		wait.until(ExpectedConditions.visibilityOf(uid));
		uid.sendKeys(username);
	}
	public void inserirPassword(String password){
		wait.until(ExpectedConditions.visibilityOf(this.password));
		this.password.sendKeys(password);
	}

	public void clicarBotaoReset(){
		wait.until(ExpectedConditions.elementToBeClickable(btnReset));
		btnReset.click();
	}

	public boolean usernameAndPasswordFieldsShouldBeEmpty(){
		Boolean isUsernameFieldEmpty = wait.until(ExpectedConditions.textToBePresentInElement(uid, ""));
		Boolean isPasswordFieldEmpty = wait.until(ExpectedConditions.textToBePresentInElement(password, ""));
		reportPrintElement(uid, Status.INFO, "Campo username");
		reportPrintElement(password, Status.INFO, "Campo password");
		return isUsernameFieldEmpty && isPasswordFieldEmpty;
	}

}
