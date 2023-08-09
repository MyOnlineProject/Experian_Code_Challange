package ExtentReporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import BasePackage.BaseSelenium;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportSetup extends BaseSelenium {

    static ExtentReports extent;

    public static ExtentReports setupExtentReports() throws IOException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date date = new Date();
        String actualDate = format.format(date);

        String reportPath = System.getProperty("user.dir")+"/reports/executionReports_"+actualDate+".html";

        ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(sparkReport);

        sparkReport.config().setDocumentTitle("Experian Test Report");
        sparkReport.config().setTheme(Theme.DARK);
        sparkReport.config().setReportName("Experian Test Report");

        extent.setSystemInfo("Execution Environment", properties.getProperty("URL"));
        extent.setSystemInfo("Execution Browser", properties.getProperty("Browser"));

        return extent;
    }
}
