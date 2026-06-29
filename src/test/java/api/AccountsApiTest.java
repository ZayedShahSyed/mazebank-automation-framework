package api;

import api.services.AccountsApiService;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import api.models.AccountsResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class AccountsApiTest {
    AccountsApiService accountsApiService;



    JsonPath resBody;
    AccountsResponse[] accountsResponses;


    @BeforeClass
    public void login(){
        accountsApiService = new AccountsApiService();
        Response res = accountsApiService.accounts();
        accountsResponses = res.as(AccountsResponse[].class);
        resBody = res.then().extract().jsonPath();


    }

    @Test
    public void verifyAccountNumber(){
        String accountNumber = accountsResponses[0].getAccountNumber();
        Assert.assertTrue(accountNumber.contains("MAZE17045978"));
    }

    @Test
    public void verifyAccountType(){
        String accountType = accountsResponses[0].getAccountType();
        Assert.assertTrue(accountType.contains("SAVINGS"));
    }

    @Test
    public void verifyAccountStatus(){
        Assert.assertTrue(accountsResponses[0].isActive());
    }


}
