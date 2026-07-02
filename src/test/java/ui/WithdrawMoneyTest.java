package ui;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.customer.DashboardPage;
import pages.customer.TransactionsPage;
import utilities.Config;
import utilities.Routes;

public class WithdrawMoneyTest extends BaseTest {
    DashboardPage dashboardPage;
    TransactionsPage transactionsPage;


    @Test(priority=1)
    public void navigateToTransactionsPage(){
        dashboardPage = hp.navigateToDashboardViaLogin(Config.getDefaultLoginEmail(),Config.getDefaultLoginPassword());
        transactionsPage = dashboardPage.navigateToTransactions();
        Assert.assertEquals(getDriver().getCurrentUrl(), Routes.transactionPage);
    }

    @Test(priority = 2)
    public void withdrawMoney(){
        String text = transactionsPage.withdrawMoney("1000");
        Assert.assertTrue(text.contains("Withdrawal successful!"));
        hp.logout();
    }

    @Test(priority = 3)
    public void withdrawMoneyFromDeactivatedAccount(){
        dashboardPage = hp.navigateToDashboardViaLogin("krishna.kertzmann@hotmail.com", "Password@123");
        transactionsPage = dashboardPage.navigateToTransactions();
        String text = transactionsPage.withdrawMoney("1000");
        Assert.assertEquals(text, "Account is deactivated");
    }


}
