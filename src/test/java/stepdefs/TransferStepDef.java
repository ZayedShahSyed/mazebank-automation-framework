package stepdefs;

import base.BaseStepDef;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.customer.DashboardPage;
import pages.customer.TransactionsPage;

public class TransferStepDef extends BaseStepDef {

    DashboardPage dashboardPage;
    TransactionsPage transactionsPage;

    public TransferStepDef(){

    }

    @Given("user is on the transactions page")
    public void navigateToTransactionsPage(){
        dashboardPage = homePage.navigateToDashboardViaLogin("lala@gmail.com","Password@123");
        transactionsPage = dashboardPage.navigateToTransactions();

    }

    @Given("user is on transfer tab")
    public void moveToTransferTab(){
        transactionsPage.moveToTransferTab();
    }

    @Given("user waits for account number to be visible")
    public void waitForAccountNumber(){
        transactionsPage.waitForAccountNumber();
    }

    @When("user enters the other account number {string}")
    public void enterOtherAccountNumber(String accountNumber){
        transactionsPage.enterAccountNumber(accountNumber);
    }

    @When("user enters the amount {string}")
    public void enterAmount(String amount){
        transactionsPage.enterAmount(amount);
    }

    @When("user clicks transfer")
    public void clickTransfer(){
        transactionsPage.clickTransfer();
    }

    @Then("user gets success alert")
    public void handleSuccessAlert(){
        String text = transactionsPage.handleAlert();
        Assert.assertEquals(text,"Transfer successful!");
    }

    @Then("user gets failure alert")
    public void userGetsFailureAlert(){
        String text = transactionsPage.handleAlert();
        Assert.assertEquals(text,"Destination account is deactivated");
    }

    @After
    public void cleanUp(){
        super.cleanUp();
    }

}
