package common;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {

    private ExtentManager(){}

    private static ExtentReports extent;
    private static String reportFileName = "relatorio_"+new SimpleDateFormat("ddMMyyyyHHmmssSSS").format(new Date())+".html";
    private static String path = System.getProperty("user.dir")+ "/target/relatorio";
    private static String reportFileLoc = path + "/" + reportFileName;

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }

    public static ExtentReports createInstance() {
        String fileName = getReportFileLocation();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.setAnalysisStrategy(AnalysisStrategy.CLASS);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(fileName);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        return extent;
    }

    private static String getReportFileLocation () {
        createReportPath(path);
        return reportFileLoc;
    }

    private static void createReportPath (String path) {
        File testDirectory = new File(path);
        if (!testDirectory.exists()) {
            testDirectory.mkdir();
        }
    }
}
