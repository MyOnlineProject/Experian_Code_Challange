package ExtentReporter;

import com.aventstack.extentreports.ExtentTest;

public class ExtentFactory {

    private ExtentFactory() {
    }

    private static final ExtentFactory instance = new ExtentFactory();

    public static ExtentFactory getInstance() {
        return instance;
    }

    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public ExtentTest getExtent() {
        return extentTest.get();
    }

    public void setExtent(ExtentTest extentParam) {
        extentTest.set(extentParam);
    }

    public void removeExtentObject() {
        extentTest.remove();
    }


}
