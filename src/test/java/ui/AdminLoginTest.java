package ui;


import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.admin.AdminLoginPage;

public class AdminLoginTest extends BaseTest {

    AdminLoginPage adminLoginPage;

    @Test
    public void adminLogin(){
        logger.info("Testing Admin Login");
        adminLoginPage = hp.navigateToAdminLoginPage();
        logger.info("Navigating to Admin Login Page");
        adminLoginPage.login("admin","admin123");
        Assert.assertEquals(getDriver().getCurrentUrl(),baseUrl+"/admin");
        logger.info("Admin Login Successful");
    }
}
