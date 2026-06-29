package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;

public class AdminDashboard extends BasePage {
    public WebDriver driver;

    private By accountsTabBtn = By.xpath("//div[@role='tab'][2]/descendant::span[text()='Accounts']");



    public AdminDashboard(WebDriver driver){
        this.driver = driver;
    }

    public void moveToAccountsTab(){
        click(driver,accountsTabBtn);
    }

    public String deactivateAccount(String accountNumber){
        By accountStatus = By.xpath("//tr[@role='row']/td[text()='"+accountNumber+"']/following-sibling::td[4]/span");
        By statusToggleBtn = By.xpath("//tr[@role='row']/td[text()='"+accountNumber+"']/following-sibling::td/button");

        if(waitForVisibility(driver,accountStatus).getText().equals("Active")){
            waitForVisibility(driver,statusToggleBtn).click();
            return handleAlerts(driver);
        }
        return "Account already deactivated";
    }

    public String activateAccount(String accountNumber){
        By accountStatus = By.xpath("//tr[@role='row']/td[text()='"+accountNumber+"']/following-sibling::td[4]/span");
        By statusToggleBtn = By.xpath("//tr[@role='row']/td[text()='"+accountNumber+"']/following-sibling::td/button");

        if(waitForVisibility(driver,accountStatus).getText().equals("Inactive")){
            waitForVisibility(driver,statusToggleBtn).click();
            return handleAlerts(driver);
        }

        return "Account is already active";
    }


}
