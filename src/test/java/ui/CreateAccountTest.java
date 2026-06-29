package ui;

import base.BaseTest;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.customer.AccountsPage;
import pages.customer.DashboardPage;
import utilities.Routes;

public class CreateAccountTest extends BaseTest {


    AccountsPage accountsPage;
    DashboardPage dashboardPage;
    Faker faker = new Faker();


    @Test(priority = 1)
    public void navigateToAccountsPage(){
        dashboardPage = hp.navigateToDashboardViaSignUp(faker.internet().emailAddress(),faker.regexify("[6-9][0-9]{9}"));
        accountsPage = dashboardPage.navigateToAccounts();

        Assert.assertEquals(getDriver().getCurrentUrl(), Routes.accountsPage);
    }

    @Test(priority = 2,testName = "SMK-003",dependsOnMethods = "navigateToAccountsPage")
    public void createAccountViaSignUp(){
        String text = accountsPage.createAccount(faker.number().digits(12), accountsPage.generatePAN());

        Assert.assertTrue(text.contains("Savings Account created successfully!"));
    }

}
