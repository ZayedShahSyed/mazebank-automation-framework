package pages.customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.admin.AdminLoginPage;
import pages.BasePage;

public class LoginPage extends BasePage {

    public WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }


    private By emailInput = By.xpath("//mat-card/descendant::input[1]");
    private By passwordInput = By.xpath("//mat-card/descendant::input[2]");
    private By loginBtnXpath = By.xpath("//button[contains(@class,'login-btn')]");


    private By adminLoginBtn = By.xpath("//a[@routerlink='/admin-login']");

    public void enterEmail(String email){
        type(driver,emailInput,email);
    }

    public void enterPassword(String password){
        type(driver,passwordInput,password);
    }

    public void clickLoginBtn(){

        click(driver,loginBtnXpath);
    }

    public DashboardPage login(String email, String password){
        enterEmail( email);
        enterPassword(password);
        clickLoginBtn();
        handleAlerts(driver);
        waitForUrlContains(driver,"dashboard");
        return new DashboardPage(driver);
    }

    public String loginWithInvalidDetails(String email,String password){
        enterEmail( email);
        enterPassword(password);
        clickLoginBtn();
        return handleAlerts(driver);
    }



    public boolean isLoggedIn(){
        waitForVisibility(driver,By.cssSelector("h2"));
        return driver.findElement(By.xpath("//h2[contains(text(),'Welcome')]")).isDisplayed();
    }


    public AdminLoginPage navigateToAdminLoginPage(){
        click(driver,adminLoginBtn);
        waitForUrlContains(driver,"admin-login");
        return new AdminLoginPage(driver);
    }

    public void handleAlert(){super.handleAlerts(driver);};
}
