package BasePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class BaseSelenium {

    public static Properties properties;
    public static WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public Properties readConfigurationFile() throws IOException {
        properties = new Properties();
        String filePath = System.getProperty("user.dir")+"/src/com.Experian/java/Configurations/config.properties";
        FileInputStream  fis = new FileInputStream(filePath);
        System.out.println("Reading Properties File");
        properties.load(fis);
        return properties;
    }

    @BeforeTest(alwaysRun = true)
    public WebDriver launchBrowser(){
        String browser = properties.getProperty("Browser");
        String url = properties.getProperty("URL");
        if(browser.equalsIgnoreCase("Chrome")){
            System.out.println("Launching Chrome Browser");
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("Firefox")){
            System.out.println("Launching Firefox browser");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.get(url);

        return driver;
    }

    public static void waitForElementPresent(By by) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        System.out.println("Waiting for web element to be visible");
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void enterTextInTextBox(By by, String text){
        waitForElementPresent(by);
        WebElement element = driver.findElement(by);
        element.click();
        System.out.println("Clicked on element located by "+ by);
        System.out.println("Entering "+ text+ "into text box");
        element.sendKeys(text);
    }

    public static void clickOnElement(By by) {
        waitForElementPresent(by);
        WebElement element = driver.findElement(by);
        element.click();
        System.out.println("Clicked on Element located by "+ by);
    }

    public static void scrollToElement(WebElement element){
        System.out.println("Scrolling to element");
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
