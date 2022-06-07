package common;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.service.ExtentTestManager;
import driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;


public class ListenerTest implements ITestListener {


    private static ExtentReports extent = BaseTest.getExtentReport();
    private static ThreadLocal<ExtentTest> test = BaseTest.getTestInstanceThread();
    private static final Logger LOGGER = LogManager.getLogger(ListenerTest.class);

    @Override
    public synchronized void onStart(ITestContext context) {
        //On start of a test behavior
        extent.setAnalysisStrategy(AnalysisStrategy.CLASS);

    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        extent.flush();
        test.remove();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        LOGGER.info((result.getMethod().getMethodName() + " started!"));
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
        test.set(extentTest);
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        LOGGER.info((result.getMethod().getMethodName() + " passed!"));
        test.get().pass("Test passed");
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        LOGGER.info((result.getMethod().getMethodName() + " failed!"));
        test.get().fail(result.getThrowable());
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        LOGGER.info((result.getMethod().getMethodName() + " skipped!"));
        test.get().skip(result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        LOGGER.info(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
    }

    public static void reportPrintPass(String log) {
        reportPrint(Status.PASS, log);
    }

    public static void reportPrintFail() {
        reportPrintFail("");
    }

    public static void reportPrintFail(String log) {
        reportPrint(Status.FAIL, log);
    }

    public static void reportPrintInfo() {
        reportPrintInfo("");
    }

    public static void reportPrintInfo(String log) {
        reportPrint(Status.INFO, log);
    }

    public static void reportInfo(String log) {
        report(Status.INFO, log);
    }

    public static void reportPass(String log) {
        report(Status.PASS, log);
    }

    public static void reportFail(String log) {
        report(Status.FAIL, log);
    }

    private static void reportPrint(Status status, String log) {
        try{
            test.get().log(status, log,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshot()).build());
        } catch(IOException e){
            LOGGER.error(e.getLocalizedMessage());
        }
    }

    private static void report(Status status, String log) {
        ExtentTestManager.getTest().log(status, log);
    }

    private static String takeScreenshot() throws IOException {
        String caminhoDiretorioCapturasTela = System.getProperty("user.dir") + "/target/relatorio/img/" +  System.currentTimeMillis() +".png";
        File capturaTela = new File(caminhoDiretorioCapturasTela);

        if(!capturaTela.getParentFile().exists()){
            capturaTela.getParentFile().mkdirs();
        }

        if(!capturaTela.createNewFile())
            throw new FileNotFoundException("Arquivo ["+capturaTela.getName()+"] nao criado.");

        File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, capturaTela);

        byte[] fileContent = FileUtils.readFileToByteArray(capturaTela);
        String encodedString = Base64.getEncoder().encodeToString(fileContent);

        return "data:image/png;base64," + encodedString;
    }

    public static void reportPrintElement(WebElement webElement, Status status, String log) {
        try{
            test.get().log(status, log,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(takeElementScreenshot(webElement)).build());
        } catch(IOException e){
            LOGGER.error(e.getLocalizedMessage());
        }
    }

    private static String takeElementScreenshot(WebElement element) throws IOException {
        String caminhoDiretorioCapturasTela = System.getProperty("user.dir") + "/target/relatorio/img/" +  System.currentTimeMillis() +".png";
        File capturaTela = new File(caminhoDiretorioCapturasTela);
        if(!capturaTela.getParentFile().exists()){
            capturaTela.getParentFile().mkdirs();
        }
        if(!capturaTela.createNewFile())
            throw new FileNotFoundException("Arquivo ["+capturaTela.getName()+"] nao criado.");

        File scrFile = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, capturaTela);

        byte[] fileContent = FileUtils.readFileToByteArray(capturaTela);
        String encodedString = Base64.getEncoder().encodeToString(fileContent);

        return "data:image/png;base64,"+encodedString;
    }

    private String getBrowser() {
        Capabilities cap = ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities();
        return StringUtils.capitalize(cap.getBrowserName().toLowerCase());
    }

    private String getVersion() {
        return  ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities().getVersion();
    }

}
