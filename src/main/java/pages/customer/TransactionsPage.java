package pages.customer;

import org.openqa.selenium.*;
import pages.BasePage;

public class TransactionsPage extends BasePage {

    public WebDriver driver;

    public TransactionsPage(WebDriver driver){
        this.driver = driver;
    }

    private By accountsInfo = By.xpath("//div[@class='account-info']");


    private By depositInput = By.xpath("//input[@data-qa='deposit-input']");
    private By depositBtn = By.xpath("//button[@data-qa='deposit-btn']");

    private By withdrawNavBtn = By.xpath("//*[contains(text(),'Withdraw') and @class='mdc-tab__text-label']");


    private By withdrawInput = By.xpath("//input[@data-qa='withdraw-input']");
    private By withdrawBtn = By.xpath("//button[@data-qa='withdraw-btn']");

    private By transferNavBtn = By.xpath("//*[contains(text(),'Transfer') and @class='mdc-tab__text-label']");
    private By transferAccountInput = By.xpath("//input[@data-qa='transfer-to-input']");
    private By transferAmountInput = By.xpath("//input[@data-qa='transfer-amt-input']");
    private By transferBtn = By.xpath("//button[@data-qa='transfer-btn']");

    public String depositMoney(String amount){
        waitForVisibility(driver,accountsInfo);
        type(driver,depositInput,amount);
        click(driver,depositBtn);
        return handleAlerts(driver);
    }

    public String withdrawMoney(String amount){

        click(driver,withdrawNavBtn);
        waitForVisibility(driver,accountsInfo);
        type(driver,withdrawInput,amount);
        click(driver,withdrawBtn);
        return handleAlerts(driver);

    }

    public void moveToTransferTab(){
        click(driver,transferNavBtn);
    }

    public void waitForAccountNumber(){
        waitForVisibility(driver,accountsInfo);
    }

    public void enterAccountNumber(String accountNumber){
        type(driver,transferAccountInput,accountNumber);
    }

    public void enterAmount(String amount){
        type(driver,transferAmountInput,amount);
    }

    public void clickTransfer(){
        click(driver,transferBtn);
    }

    public String handleAlert(){
        return super.handleAlerts(driver);
    }

}
