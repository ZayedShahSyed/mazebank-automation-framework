package ui;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.customer.LoginPage;

public class LoginPageTest extends BaseTest {


    private LoginPage loginPage;

    @Test(priority = -1)
    public void isLoginPageVisible(){
        loginPage = hp.navigateToLoginPage();
        Assert.assertTrue(getDriver().findElement(By.xpath("//p[contains(text(),'Welcome')]")).isDisplayed());
    }



    @Test(priority = 2, testName = "SMK-002",description = "Verify User Login Functionality",dependsOnMethods = "isLoginPageVisible")
    public void loginWithValidDetails(){
        logger.info("Login With Valid Details");
        loginPage.login("lala@gmail.com","Password@123");

        Assert.assertTrue(loginPage.isLoggedIn());
        logger.info(("Ending Valid login"));

    }

    @Test(priority = 1)
    public void loginWithInvalidDetails(){
        String text = loginPage.loginWithInvalidDetails("lala@gmail.com","password@11");
        Assert.assertFalse(text.contains("Welcome"));

    }



}
