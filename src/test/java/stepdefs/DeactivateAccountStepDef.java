package stepdefs;

import base.BaseStepDef;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.admin.AdminDashboard;
import pages.admin.AdminLoginPage;

public class DeactivateAccountStepDef extends BaseStepDef {
    AdminLoginPage adminLoginPage;
    AdminDashboard adminDashboard;
    String text;

    @Given("admin is logged into the application")
    public void adminIsLoggedIntoTheApplication(){
        adminLoginPage = homePage.navigateToAdminLoginPage();
        adminDashboard = adminLoginPage.login("admin","admin123");
        Assert.assertEquals(getDriver().getCurrentUrl(),baseUrl+"/admin");
    }

    @Given("admin is on the accounts tab")
    public void adminIsOnAccountsTab(){
        adminDashboard.moveToAccountsTab();
    }

    @When("admin clicks deactivate button for account number {string}")
    public void adminClicksDeactivateButton(String accountNumber){
        text = adminDashboard.deactivateAccount(accountNumber);
    }

    @Then("account is deactivated")
    public void verifyIsAccountDeactivated(){
        Assert.assertEquals(text,"Account deactivated successfully!");
    }

    @When("admin clicks activate button for account number {string}")
    public void adminClicksActivateButton(String accountNumber){
        text = adminDashboard.activateAccount(accountNumber);
    }

    @Then("account is activated")
    public void verifyIsAccountActivated(){

        Assert.assertEquals(text,"Account activated successfully!");
    }

    @After
    public void cleanUp(){
        super.cleanUp();
    }
}
