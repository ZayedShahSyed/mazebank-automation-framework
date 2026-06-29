package pages.customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.BasePage;


public class SignUpPage extends BasePage {

    public WebDriver driver;

    public SignUpPage(WebDriver driver){
        this.driver = driver;
    }


    private By fullName = By.xpath("//mat-card/descendant::input[1]");
    private By email = By.xpath("//mat-card/descendant::input[2]");
    private By phoneNumber = By.xpath("//mat-card/descendant::input[3]");
    private By address = By.xpath("//mat-card/descendant::input[4]");
    private By password = By.xpath("//mat-card/descendant::input[5]");

    private By registerBtn = By.xpath("//app-register/descendant::button");



    public LoginPage signUp(String fullName, String email, String phoneNumber, String address, String password){
        type(driver,this.fullName,fullName);
        type(driver,this.email,email);
        type(driver,this.phoneNumber,phoneNumber);
        type(driver,this.address,address);
        type(driver,this.password,password);

        click(driver,registerBtn);

        Assert.assertTrue(handleAlerts(driver).contains("successful"));
        waitForUrlContains(driver,"login");

        return new LoginPage(driver);

    }

    public String signUpWithExistingDetails(String fullName,String email,String phoneNumber,String address,String password){
        type(driver,this.fullName,fullName);
        type(driver,this.email,email);
        type(driver,this.phoneNumber,phoneNumber);
        type(driver,this.address,address);
        type(driver,this.password,password);

        click(driver,registerBtn);
        return handleAlerts(driver);

    }


}
