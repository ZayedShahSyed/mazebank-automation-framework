package pages.customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class DashboardPage extends BasePage {
    public WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver=driver;
    }

    private By accountBtn = By.xpath("//button[@routerlink='/accounts']");
    private By transactionsBtn = By.xpath("//button[@routerlink='/transactions']");
    private By accountsInfo = By.xpath("//div[@class='account-info']");

    public AccountsPage navigateToAccounts(){
        click(driver,accountBtn);
        waitForUrlContains(driver,"accounts");
        return new AccountsPage(driver);
    }

    public TransactionsPage navigateToTransactions(){
        click(driver,transactionsBtn);
        waitForVisibility(driver,accountsInfo);
        return new TransactionsPage(driver);
    }
}
