package ExtentReporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import BasePackage.BaseSelenium;
import java.io.IOException;

public class ListenerImplementation implements ITestListener {

    static ExtentReports report;
           ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = report.createTest(result.getMethod().getMethodName());
        ExtentFactory.getInstance().setExtent(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentFactory.getInstance().getExtent().log(Status.PASS,"Test Case: "+result.getMethod().getMethodName()+" is passed");
        ExtentFactory.getInstance().removeExtentObject();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentFactory.getInstance().getExtent().log(Status.FAIL,"Test Case: "+result.getMethod().getMethodName()+" is failed");
        ExtentFactory.getInstance().getExtent().log(Status.FAIL,result.getThrowable());

        String screenshotPath = ((TakesScreenshot) BaseSelenium.driver).getScreenshotAs(OutputType.BASE64);
        Media screenshot = MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build();
        try{
            ExtentFactory.getInstance().getExtent().fail("Test Fail Screenshot",screenshot);
            ExtentFactory.getInstance().removeExtentObject();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentFactory.getInstance().getExtent().log(Status.SKIP,"Test Case: "+result.getMethod().getMethodName()+" is skipped");
        ExtentFactory.getInstance().removeExtentObject();

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        try{
            report = ExtentReportSetup.setupExtentReports();
        }catch (IOException e){
           e.printStackTrace();
        }

    }

    @Override
    public void onFinish(ITestContext context) {
        report.flush();
    }
}
