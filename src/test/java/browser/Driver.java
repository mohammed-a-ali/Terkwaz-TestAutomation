package browser;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;
import utilities.LoadProperties;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Driver {

    public ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;
    public static ExtentTest test;
    public static WebDriver driver;
    static String browserName = LoadProperties.environment.getProperty("browser").toLowerCase();

    @BeforeTest
    public static void startDriver() {
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        } else if (browserName.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.MILLISECONDS);
    }

    @AfterTest
    public static void stopDriver() {
        driver.quit();
    }

    @BeforeSuite
    public void setExtent() {
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/Report.html");

        //Set the title of the Report
        sparkReporter.config().setDocumentTitle("Automation Report");
        //Set the name of the report
        sparkReporter.config().setReportName("Trekwaz Report");
        //Set the theme of the report
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();

        //Attach the reporter
        extent.attachReporter(sparkReporter);
    }

    //Take a screenshot when testcase fails and add it to the Screenshot folder
    @AfterMethod
    public void ScreenshotOnFailure(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            //Add Test case name into the extent report
            test.log(Status.FAIL, "TEST CASE " + result.getName() + " IS FAILED");
            //Add the exception into the extent report
            test.log(Status.FAIL, "TEST CASE IS FAILED DUE TO " + result.getThrowable());
            String screenshotPath = Helper.reportScreenshot(driver, result.getName());
            //Add screenshot to the report
            test.addScreenCaptureFromPath(screenshotPath);
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "TEST CASE " + result.getName() + " IS SKIPPED");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "TEST CASE " + result.getName() + " IS PASSED");
            String screenshotPath = Helper.reportScreenshot(driver, result.getName());
            //Add screenshot to the report
            test.addScreenCaptureFromPath(screenshotPath);
        }
    }

    @AfterSuite
    public void endReport() {
        extent.flush();
    }
}
