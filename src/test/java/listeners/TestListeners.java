package listeners;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.DriverFactory;
import utilities.DriverManager;

import java.io.File;
import java.util.Date;

public class TestListeners extends BaseTest implements ITestListener  {

    private static ExtentReports extent = ExtentManager.createInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();


    @Override
    public void onStart(ITestContext context) {
        // Triggered before any test tags in testng.xml start
        logger = LogManager.getLogger(this.getClass());
        logger.info("Starting Logger for Listeners");


    }

    @Override
    public void onTestStart(ITestResult result) {
        // Create a new test entry in the report
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
        logger.info("Starting Test: {}",result.getMethod());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().log(Status.PASS, "Test Passed");
        logger.info("{} Successful",result.getMethod());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult){
        try{
            logger.fatal("Test Failed: {}",iTestResult.getMethod());
            test.get().log(Status.FAIL, "Test Failed: " + iTestResult.getThrowable());
            TakesScreenshot ts = (TakesScreenshot) getDriver();
            File src = ts.getScreenshotAs(OutputType.FILE);

            String fileAppender = iTestResult.getName()+new Date().toString().replace(" ","").replace(":","")+".png";
            String path ="target/ExtentReports/screenshots/"+fileAppender;

            File dest = new File(path);

            FileHandler.copy(src,dest);
            test.get().addScreenCaptureFromPath("screenshots/"+fileAppender);

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void onFinish(ITestContext context) {
        // CRITICAL: Writing all data to the HTML file
        if (extent != null) {
            extent.flush();
        }
        logger.info("Ending Listener");
    }

}
