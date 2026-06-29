package stepdefs;

import base.BaseStepDef;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.customer.LoginPage;

public class LogoutStepDef extends BaseStepDef {

    @Given("user is logged in with email {string} and password {string}")
    public void userIsLoggedIn(String email,String password){
        LoginPage loginPage = homePage.navigateToLoginPage();
        loginPage.login(email,password);
    }

    @When("user logs out of his account")
    public void userLogsOut(){
        homePage.logout();
    }

    @Then("user is logged out")
    public void isUserLoggedOut(){
        getDriver().get(baseUrl+"/dashboard");
        waitForUrl(baseUrl+"/login");
        Assert.assertEquals(getDriver().getCurrentUrl(), (baseUrl + "/login"));
    }

    @After
    public void cleanUp(){super.cleanUp();}
}
