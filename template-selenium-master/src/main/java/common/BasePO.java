package common;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static common.ListenerTest.reportInfo;
import static common.ListenerTest.reportPrintFail;

public class BasePO extends AbstractPageObject {

    private WebDriver driver;
    private WebDriverWait wait;

    public BasePO() {
        driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public boolean verifyElementIsNotVisible(WebElement elemento, String msgErro) {

        try {
            wait.until(ExpectedConditions.visibilityOf(elemento));
            reportPrintFail(msgErro);
        } catch (Exception e) {
            return true;
        }
        return false;
    }

    public boolean verifyElementIsVisible(WebElement elemento, String msgErro) {

        try {
            wait.until(ExpectedConditions.visibilityOf(elemento));
        } catch (Exception e) {
            reportPrintFail(msgErro);
            return false;
        }
        return true;
    }

    public boolean verifyElementTextIsEmpty(WebElement elemento, String msgErro) {

        try {
            wait.until(ExpectedConditions.visibilityOf(elemento));
            if (elemento.getText().isEmpty() || elemento.getAttribute("value").isEmpty())
                return true;
            else
                reportPrintFail(msgErro);
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public boolean verifyElementTestIsNotEmpty(WebElement elemento, String msgErro) {

        try {
            wait.until(ExpectedConditions.visibilityOf(elemento));
            if (!elemento.getText().isEmpty() || !elemento.getAttribute("value").isEmpty())
                return true;
            else
                reportPrintFail(msgErro);
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public boolean verifyElementIsNotVisible(String xpath, String msgErro) {
        try {
            if (driver.findElements(By.xpath(xpath)).isEmpty()) {
                reportPrintFail(msgErro);
                return false;
            }
        } catch (Exception e) {
            //Elemento nao esta visivel
        }
        return true;

    }

    public boolean waitUntilElementIsVisible(String xpath, String msgErro) {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
            return true;

        } catch (Exception e) {
            //Elemento nao esta visivel
        }
        reportPrintFail(msgErro);
        return false;
    }

    public boolean waitUntilElementIsNotVisible(String xpath, String msgErro) {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
            return true;

        } catch (Exception e) {
            //Elemento nao esta visivel
        }
        reportPrintFail(msgErro);
        return false;
    }

    public void waitUntilElementDoesNotHaveText(WebElement elemento, String texto) {
        int maxRetries = 30;
        int count = 1;
        while (count++ < maxRetries) {
            Boolean hasText = wait.withTimeout(Duration.ofSeconds(1)).pollingEvery(Duration.ofMillis(200)).until(ExpectedConditions.textToBePresentInElement(elemento, texto));
            if (hasText == null || !hasText)
                break;
        }
    }

    public void sendKeysCharByChar(String texto, WebElement elemento) {
        for (char c : texto.toCharArray()) {
            elemento.sendKeys(String.valueOf(c));
        }
    }

    public void clickButton(WebElement botao) {
        wait.until(ExpectedConditions.elementToBeClickable(botao));
        botao.click();
        reportInfo("Cliclou no botão");
    }

    /**
     * Wait until all javascripts and jqueries finish execution or timeout
     * @return
     */
    public boolean waitForJSAndJQtoLoad() {
        Boolean isJQueryFinished = wait.until(d -> ((Long) ((JavascriptExecutor) d).executeScript("return jQuery.active") == 0));
        Boolean isDomLoaded = wait.until(d -> ((JavascriptExecutor) d).executeScript("return document.readyState").toString()
                .equals("complete"));

        return isJQueryFinished && isDomLoaded;
    }

}
