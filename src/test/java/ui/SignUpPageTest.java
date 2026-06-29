package ui;

import base.BaseTest;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.Test;
import pages.customer.SignUpPage;

public class SignUpPageTest extends BaseTest {


    private SignUpPage signup;
    Faker faker = new Faker();


    @Test(priority = 1,testName = "SMK-001",description = "Verify User Registration")
    public void isSignUpPageVisible(){
        signup = hp.navigateToRegisterPage();

        Assert.assertTrue(getDriver().findElement(By.xpath("//h1[text()='Create Account']")).isDisplayed());
    }

    @Test(priority = 2)
    public void signUpWithValidDetails(){
        signup.signUp("ValidUser",faker.internet().emailAddress(),faker.regexify("[6-9][0-9]{9}"),"cognizant","Password@123");
        Assert.assertEquals(getDriver().getCurrentUrl(), baseUrl+"/login");

    }

    @Test(priority = 3)
    public void signUpWithExistingEmail(){
        signup=hp.navigateToRegisterPage();
        String text = signup.signUpWithExistingDetails("ValidUser","never@gmail.com","8081179997","cognizant","Password@123");

        Assert.assertTrue(text.contains("already"));

    }

}
