package loginClientes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BaseTest {
	
	private static WebDriver driver;
	
	@Before
	public void BeforeCenario() {
		
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/ChromeDriver.exe");
		
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.navigate().to("https://www.betatest.lit.com.br");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void waitElement(WebElement mensagemInicial) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By)(mensagemInicial)));
		
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	@After
	public void close() {
		driver.quit();
	}
}
