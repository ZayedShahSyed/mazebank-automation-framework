package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;

    public static synchronized ExtentReports createInstance() {
        if (extent == null) {
            // Set the report file destination


                ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/ExtentReports/TestReport.html");
                // Configuration

                sparkReporter.config().setTheme(Theme.DARK);
                sparkReporter.config().setDocumentTitle("Automation Test Report");
                sparkReporter.config().setReportName("Smoke Execution Results");

                extent = new ExtentReports();
                extent.attachReporter(sparkReporter);

                // System/Environment info
                extent.setSystemInfo("OS", System.getProperty("os.name"));
                extent.setSystemInfo("Environment", "QA");
                extent.setSystemInfo("Executor", "QA Team");

        }
        return extent;
    }
}