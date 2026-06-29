package stepdefs;

import base.BaseStepDef;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.customer.LoginPage;
import utilities.DriverManager;
import utilities.Routes;


public class LoginStepdef extends BaseStepDef {


    LoginPage loginPage;

    public LoginStepdef(){

    }


    @Given("user is on the login page")
    public void userIsOnTheLoginPage(){
        loginPage = homePage.navigateToLoginPage();
        Assert.assertEquals(DriverManager.getDriver().getCurrentUrl(), Routes.loginPage);
    }

    @When("user enters email {string} and password {string}")
    public void userEntersEmailAndPassword(String email,String password){
       loginPage.enterEmail(email);
       loginPage.enterPassword(password);
    }

    @When("user clicks login button")
    public void userClicksLoginButton(){
        loginPage.clickLoginBtn();
    }

    @Then("user handles alert")
    public void userHandlesAlert(){
        loginPage.handleAlert();
    }

    @Then("user logs into the dashboard")
    public void userLogsIntoTheDashboard(){
        Assert.assertTrue(loginPage.isLoggedIn());
    }



    @After
    public void cleanUp(){
        super.cleanUp();
    }


}
