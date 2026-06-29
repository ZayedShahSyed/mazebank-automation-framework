package ui;


import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.admin.AdminLoginPage;
import utilities.Routes;

public class AdminLoginTest extends BaseTest {

    AdminLoginPage adminLoginPage;

    @Test
    public void adminLogin(){
        adminLoginPage = hp.navigateToAdminLoginPage();
        adminLoginPage.login("admin","admin123");
        Assert.assertEquals(getDriver().getCurrentUrl(), Routes.adminDashboard);
    }
}
