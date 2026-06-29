package base;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import utilities.Config;
import utilities.DriverFactory;
import utilities.DriverManager;

import java.time.Duration;

public class BaseTest {

    protected String baseUrl = Config.getBaseUrl();
    public Logger logger;
    public HomePage hp;

    @BeforeClass(alwaysRun = true)
    public void setup() {

        WebDriver driver = DriverFactory.createDriver(Config.getBrowser(),Config.getHeadless());

        DriverManager.setDriver(driver);

        getDriver().manage().window().maximize();
        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(Config.getImplicitWaitTime()));

        getDriver().get(baseUrl);

        logger = LogManager.getLogger(this.getClass());

        hp = new HomePage(getDriver());
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }

    protected WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    protected WebDriverWait webWait(){
        return new WebDriverWait(getDriver(),Duration.ofSeconds(Config.getExplicitWaitTime()));
    }
}