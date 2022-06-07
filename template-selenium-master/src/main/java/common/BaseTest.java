package common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import driver.DriverFactory;
import driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Listeners(ListenerTest.class)
public class BaseTest  extends AbstractTestNGCucumberTests{

	private static ExtentReports extent = ExtentManager.getInstance();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void beforeCenario(@Optional("chrome") String browser) {

		WebDriver driver = DriverFactory.criarInstancia(browser);
		DriverManager.setDriver(driver);

		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().navigate().to("http://demo.guru99.com/v4/");
	}
	
	public static WebDriver getDriver() {
		return DriverManager.getDriver();
	}

	@AfterMethod(alwaysRun = true)
	public void close() {
		DriverManager.getDriver().quit();
	}

	@AfterSuite
	public void updateReport() throws IOException {

		test.remove();
		File theNewestFile = getTheNewestFile("target/relatorio", "html");
		String htmlContent = FileUtils.readFileToString(theNewestFile, "utf-8");

		String pattern = "href='([^'].*)' data-featherlight";

		Pattern r = Pattern.compile(pattern);
		Matcher matcher = r.matcher(htmlContent);

		Set<String> keyList = new HashSet();

		while (matcher.find()) {
			keyList.add(matcher.group(1));
		}
		for (String data : keyList) {
			String oldString = data + "' data-featherlight='image'>";
			htmlContent = htmlContent.replace(oldString, oldString + "<img src='" + data + "' style=\"width:150px\">");
		}
		htmlContent = htmlContent.replace("<span class='label grey badge white-text text-white'>base64-img</span>", "");

		FileUtils.writeStringToFile(theNewestFile, htmlContent, "utf-8");
	}

	public File getTheNewestFile(String filePath, String ext) {
		File theNewestFile = null;
		File dir = new File(filePath);
		FileFilter fileFilter = new WildcardFileFilter("*." + ext);
		File[] files = dir.listFiles(fileFilter);

		if (files.length > 0) {
			/** The newest file comes first **/
			Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
			theNewestFile = files[0];
		}

		return theNewestFile;
	}

	public static ExtentReports getExtentReport(){
		return extent;
	}

	public static ThreadLocal<ExtentTest> getTestInstanceThread(){
		return test;
	}


}
