package ui;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.customer.DashboardPage;
import pages.customer.TransactionsPage;

public class DepositMoneyTest extends BaseTest {

    DashboardPage dashboardPage;
    TransactionsPage transactionsPage;

    @Test(priority=1)
    public void navigateToTransactionsPage(){
        dashboardPage = hp.navigateToDashboardViaLogin("lala@gmail.com","Password@123");
        transactionsPage = dashboardPage.navigateToTransactions();
        Assert.assertEquals(getDriver().getCurrentUrl(),baseUrl+"/transactions");

    }

    @Test(priority = 2)
    public void depositMoney(){

        String text = transactionsPage.depositMoney("100991");
        Assert.assertTrue(text.contains("Deposit successful!"));
        hp.logout();

    }

    @Test(priority = 3)
    public void depositMoneyIntoDeactivatedAccount() {
        dashboardPage = hp.navigateToDashboardViaLogin("vikash431@gmail.com", "Password@123");
        transactionsPage = dashboardPage.navigateToTransactions();
        String text = transactionsPage.depositMoney("1000");
        Assert.assertEquals(text, "Account is deactivated");
    }
}
