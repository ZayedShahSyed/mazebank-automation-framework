package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class AdminLoginPage extends BasePage {

    public WebDriver driver;

    public AdminLoginPage(WebDriver driver){
        this.driver = driver;
    }

    private By adminUsername = By.xpath("//input[1]");
    private By adminPassword = By.xpath("//input[@type='password']");

    private By loginBtn = By.xpath("//button/descendant::span[text()='Admin Login']/ancestor::button");

    private By adminText = By.xpath("//h2[text()='Admin Dashboard']");

    public AdminDashboard login(String username,String password){
        type(driver,adminUsername,username);
        type(driver,adminPassword,password);
        click(driver,loginBtn);
        waitForVisibility(driver,adminText);
        return new AdminDashboard(driver);
    }
}
