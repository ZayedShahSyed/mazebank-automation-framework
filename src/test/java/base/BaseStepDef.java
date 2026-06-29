package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import utilities.Config;
import utilities.DriverFactory;
import utilities.DriverManager;
import org.apache.logging.log4j.Logger;


import java.sql.Driver;
import java.time.Duration;

import static utilities.DriverManager.getDriver;

public class BaseStepDef {
    public HomePage homePage;
    public Logger logger;
    public String baseUrl =Config.getBaseUrl();

    public BaseStepDef(){

        WebDriver driver = DriverFactory.createDriver(Config.getBrowser(),Config.getHeadless());

        DriverManager.setDriver(driver);

        getDriver().manage().window().maximize();
        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(Config.getImplicitWaitTime()));

        getDriver().get(baseUrl);

        logger = LogManager.getLogger(this.getClass());

        homePage = new HomePage(getDriver());
    }

    public WebDriver getDriver(){
        return DriverManager.getDriver();
    }


    public void cleanUp(){
        DriverManager.quitDriver();
    }

    public WebDriverWait webWait(){
        return new WebDriverWait(getDriver(),Duration.ofSeconds(Config.getExplicitWaitTime()));
    }

    public boolean waitForUrl(String text){
        return webWait().until(ExpectedConditions.urlToBe(text));
    }

}
