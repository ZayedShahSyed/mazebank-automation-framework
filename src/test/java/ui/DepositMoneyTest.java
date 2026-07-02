package ui;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.customer.DashboardPage;
import pages.customer.TransactionsPage;
import utilities.Config;
import utilities.Routes;

public class DepositMoneyTest extends BaseTest {

    DashboardPage dashboardPage;
    TransactionsPage transactionsPage;

    @Test(priority=1)
    public void navigateToTransactionsPage(){
        dashboardPage = hp.navigateToDashboardViaLogin(Config.getDefaultLoginEmail(),Config.getDefaultLoginPassword());
        transactionsPage = dashboardPage.navigateToTransactions();
        Assert.assertEquals(getDriver().getCurrentUrl(), Routes.transactionPage);

    }

    @Test(priority = 2)
    public void depositMoney(){

        String text = transactionsPage.depositMoney("100991");
        Assert.assertTrue(text.contains("Deposit successful!"));
        hp.logout();

    }

    @Test(priority = 3)
    public void depositMoneyIntoDeactivatedAccount() {
        dashboardPage = hp.navigateToDashboardViaLogin("krishna.kertzmann@hotmail.com", "Password@123");
        transactionsPage = dashboardPage.navigateToTransactions();
        String text = transactionsPage.depositMoney("1000");
        Assert.assertEquals(text, "Account is deactivated");
    }
}
